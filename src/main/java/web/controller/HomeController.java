package web.controller;

import core.dao.CategoryDao;
import core.dao.ProductDao;
import core.entity.Product;
import core.service.CategoryService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;

//    @RequestMapping("")
//    public String showCategories(ModelMap model) {
//        model.addAttribute("categories", categoryDao.findAll());
//        return "category-list";
//    }
//
//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public String showProducts(ModelMap model, @RequestParam("category_id") Integer id) {
//        List<Product> products = productDao.findAll();
//        for(Product product: products) {
//            if(!product.getCategory().getId().equals(id)) {
//                products.remove(product);
//            }
//        }
//        model.addAttribute("products", products);
//        return "product-list";
//    }
//
//    @RequestMapping(value = "product/create", method = RequestMethod.GET)
//    public String createProduct(){
//        return "create-product";
//    }
//
//    @RequestMapping(value = "product/create", method = RequestMethod.POST)
//    public String createProductHandler(ModelMap model, @RequestParam("product") String product){
//        model.addAttribute("product", product);
//        return "create-product-success";
//    }

}
