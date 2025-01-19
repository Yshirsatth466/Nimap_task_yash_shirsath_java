package com.base.ServiceI;

import org.springframework.data.domain.Page;


import org.springframework.data.domain.Pageable;

import com.base.model.Category;

public interface CategoryService {
	    Category createCategory(Category category);
	  
	    Category updateCategory(Long id, Category category);
	    
	    Category getCategoryById(Long id);
	    
	    void deleteCategory(Long id);
	    
	    Page<Category> getAllCategories(Pageable pageable);

}
