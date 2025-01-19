package com.base.Controller;

import com.base.model.Product;
import com.base.ServiceI.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService prserv;
    
    //inject sencondary dependacy or ref

    @PostMapping
    public Product createProduct(@RequestBody Product product) {//new product obj 
        return prserv.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {//update present product
        return prserv.updateProduct(id, product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {//get one product using id
        return prserv.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {//delete requst using id
        prserv.deleteProduct(id);
    }

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,//pagination using jpa
                                        @RequestParam(defaultValue = "10") int size) {
        return prserv.getAllProducts(PageRequest.of(page, size));
    }
}
