package web.controller;

import core.service.CategoryService;
import core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @RequestMapping("")
    public String showCategoryList(ModelMap model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category-list";
    }

    @RequestMapping(value = "categories/{id}", method = RequestMethod.GET)
    public String showCategoryPage(ModelMap model, @PathVariable("id") Integer id) {
        model.addAttribute("products", productService.getProductsByCategoryId(id));
        return "product-list";
    }

}
