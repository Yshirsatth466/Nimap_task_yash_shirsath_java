
package com.base.ServiceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.model.Product;

public interface ProductService {
	
	Product createProduct(Product product);
	
    Product updateProduct(Long id, Product product);
    
    Product getProductById(Long id);
    
    void deleteProduct(Long id);
    
    Page<Product> getAllProducts(Pageable pageable);

}
