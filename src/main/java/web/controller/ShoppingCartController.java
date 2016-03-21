package web.controller;

import core.entity.CustomerProductRelation;
import core.entity.Product;
import core.service.CustomerProductRelationService;
import core.service.CustomerService;
import core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {
    @Autowired
    CustomerProductRelationService customerProductRelationService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showShoppingCart(ModelMap model, HttpServletRequest request) {
        Map<Product, Integer> products = new HashMap<Product, Integer>();
        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
        for (Integer pId : sessionProducts.keySet()) {
            products.put(productService.getProductById(pId), sessionProducts.get(pId));
        }
//        Map<Product, BigDecimal> costs = new HashMap<Product, BigDecimal>();
//        Map<Integer, BigDecimal> sessionCosts = getSafeCosts(request.getSession());
//        for (Integer id : sessionCosts.keySet()){
//            costs.put(productService.getProductById(id), sessionCosts.get(id));
//        }
        model.addAttribute("productsInCart", products);
//        model.addAttribute("productCosts", costs);
        return "shopping-cart";
    }

//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public String add(HttpServletRequest request, @RequestParam("id") Integer id) {
//        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
//        sessionProducts.put(id, 1);
////        request.getSession().setAttribute("count", sessionProducts.get(id));
//        return "redirect:/shopping-cart";
//    }

//    @RequestMapping(value = "change-amount", method = RequestMethod.GET)
//    public String addOneToAmount(HttpServletRequest request, @RequestParam("count") Integer count, @RequestParam("id") Integer id){
//        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
//        sessionProducts.put(id, count+1);
//        return "redirect:/shopping-cart";
//    }

    @RequestMapping(value = "change-amount", method = RequestMethod.POST)
    public String changeAmount(ModelMap model, HttpSession session, HttpServletRequest request, @RequestParam("count") Integer count, @RequestParam("id") Integer id) {
        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
        sessionProducts.put(id, count);
        BigDecimal cost = new BigDecimal(0);
        for(Integer key: sessionProducts.keySet()){
            cost = cost.add(productService.getProductById(key).getPrice().multiply(new BigDecimal(sessionProducts.get(key))));
        }
        session.setAttribute("cost", cost);
        return "redirect:/shopping-cart";
    }


    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id, HttpServletRequest request) {
        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
        sessionProducts.remove(id);
        return "redirect:/shopping-cart";
    }

    private Map<Integer, BigDecimal> getSafeCosts(HttpSession session){
        if (session.getAttribute("costs") == null){
            session.setAttribute("costs", new HashMap<Integer, BigDecimal>());
        }
        return (Map<Integer, BigDecimal>) session.getAttribute("costs");
    }

    private Map<Integer, Integer> getSafeCustomerProducts(HttpSession session) {
        if (session.getAttribute("customerProducts") == null) {
            session.setAttribute("customerProducts", new HashMap<Integer, Integer>());
        }
        return (Map<Integer, Integer>) session.getAttribute("customerProducts");
    }
}
