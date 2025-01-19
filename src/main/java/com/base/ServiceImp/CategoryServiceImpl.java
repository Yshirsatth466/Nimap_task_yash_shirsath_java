
package com.base.ServiceImp;

import com.base.model.Category;


import com.base.repository.CategoryRepository;
import com.base.ServiceI.CategoryService;
import com.base.ServiceImp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
   //create new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

  
 
    @Override
    public Category getCategoryById(Long id) {//get one obj using id
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found id:" + id));
    }

    
    
    @Override
    public void deleteCategory(Long id) {//delete
        categoryRepository.deleteById(id);
    }
    
    

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
    
    
    
    
    public Category updateCategory(Long id, Category category) {
        Optional<Category> presentcategory = categoryRepository.findById(id);//get one obj using id a
        if (presentcategory.isPresent()) {
        	
        	//check it is preset or not
            Category updatedCategory = presentcategory.get();
            //update values
            updatedCategory.setCname(category.getCname());
            updatedCategory.setProducts(category.getProducts());
            return categoryRepository.save(updatedCategory);
        } else {
            throw new RuntimeException("Category not found id"+ id);
        }
    }
}