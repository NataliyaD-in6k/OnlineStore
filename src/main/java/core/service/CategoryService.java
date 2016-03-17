package core.service;

import core.dao.CategoryDao;
import core.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public void createCategory(Category category) {
        categoryDao.create(category);
    }

    @Transactional
    public List<Category> getAllCategories(){
        return categoryDao.findAll();
    }

    @Transactional
    public Category getCategoryById(Integer id){
        return categoryDao.findById(id);
    }

}
