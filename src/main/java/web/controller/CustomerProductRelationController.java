package web.controller;

import core.entity.CustomerProductRelation;
import core.entity.Product;
import core.service.CustomerProductRelationService;
import core.service.CustomerService;
import core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shopping_cart")
public class CustomerProductRelationController {
    @Autowired
    CustomerProductRelationService customerProductRelationService;

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/{id}")
    public String showShoppingCart(ModelMap model, @PathVariable("id") Integer id){
        model.addAttribute("products_in_cart", customerProductRelationService.getCustomerProductRelationByCustomerId(id));
        return "shopping-cart";
    }

}
