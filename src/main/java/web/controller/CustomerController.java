package web.controller;

import core.entity.Customer;
import core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("")
    public String showAllCustomers(ModelMap modelMap) {
        modelMap.addAttribute("customers", customerService.getAllCustomers());
        return "customer-list";
    }

}
