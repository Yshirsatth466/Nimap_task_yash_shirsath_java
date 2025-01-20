package com.base.Controller;

import com.base.model.Product;
import com.base.ServiceI.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService prserv;
    
    //inject sencondary dependacy or ref

 

      @PostMapping   // Endpoint to create a product
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            // Calling the service method to create the product
            Product createdProduct = prserv.createProduct(product);

            // Returning a successful response with the created product
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (RuntimeException ex) {
            // Handle runtime exceptions
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            // Handle any other unexpected exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    
    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {//update present product
        return prserv.updateProduct(id, product);
    }
}
