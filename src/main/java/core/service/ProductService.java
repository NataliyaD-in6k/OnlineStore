package core.service;

import core.dao.ProductDao;
import core.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    @Transactional
    public List<Product> getProductsByCategoryId(Integer id) {
        List<Product> products = new ArrayList<Product>();

        for(Product product: productDao.findAll()) {
            if(product.getCategory().getId().equals(id)) {
                products.add(product);
            }
        }

        return products;
    }
}
