package core.service;

import core.dao.CustomerProductRelationDao;
import core.entity.CustomerProductRelation;
import core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerProductRelationService {

    @Autowired
    private CustomerProductRelationDao customerProductRelationDao;

    public List<CustomerProductRelation> getCustomerProductRelationByCustomerId(Integer id){
        List<CustomerProductRelation> products = new ArrayList<CustomerProductRelation>();
        for(CustomerProductRelation c : customerProductRelationDao.findAll()) {
            if(c.getCustomer().getId().equals(id)) {
                products.add(c);
            }
        }
        return products;
    }

}
