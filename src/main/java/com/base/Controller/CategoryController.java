package com.base.Controller;

import com.base.ServiceI.CategoryService;
import com.base.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService cserv;
    // to inject secondary dependency

    @PostMapping
    public Category createnewCategory(@RequestBody Category category)  {//to get one json obj
        return cserv.createCategory(category);
    }

  
    

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {//send get req using id
        return cserv.getCategoryById(id);
    }

    
    
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {//delete req using id
        cserv.deleteCategory(id);
    }

    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,//pagination concept using jpa repo
                                           @RequestParam(defaultValue = "10") int size) {
        return cserv.getAllCategories(PageRequest.of(page, size));
    }
    
    
    
    
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {//to get one json obj  with existingb obj id
        return cserv.updateCategory(id, category);
    }
}
