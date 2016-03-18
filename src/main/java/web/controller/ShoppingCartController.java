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
        model.addAttribute("productsInCart", products);
        return "shopping-cart";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(HttpServletRequest request, @RequestParam("id") Integer id) {
        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
        sessionProducts.put(id, 1);
        return "redirect:/shopping-cart";
    }

    @RequestMapping(value = "change-amount", method = RequestMethod.POST)
    public String changeAmount(HttpServletRequest request, @RequestParam("count") Integer count, @RequestParam("id") Integer id) {
        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
//        sessionProducts.remove(id);
        sessionProducts.put(id, count);
        return "redirect:/shopping-cart";
    }


    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id, HttpServletRequest request) {
        Map<Integer, Integer> sessionProducts = getSafeCustomerProducts(request.getSession());
        sessionProducts.remove(id);
        return "redirect:/shopping-cart";
    }


    private Map<Integer, Integer> getSafeCustomerProducts(HttpSession session) {
        if (session.getAttribute("customerProducts") == null) {
            session.setAttribute("customerProducts", new HashMap<Integer, Integer>());
        }
        return (Map<Integer, Integer>) session.getAttribute("customerProducts");
    }
}
