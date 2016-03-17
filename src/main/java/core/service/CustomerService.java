package core.service;

import core.dao.CustomerDao;
import core.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Transactional
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerDao.findAll();
        for(Customer customer: customers) {
            customer.getProducts().size();
        }
        return customers;
    }
}
