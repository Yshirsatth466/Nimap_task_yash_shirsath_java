package com.base.ServiceImp;

import com.base.model.Product;
import com.base.repository.ProductRepository;
import com.base.ServiceI.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)//get one obj using id
                .orElseThrow(() -> new RuntimeException(" not found id:" + id));//custome excep
    }

    @Override
    public void deleteProduct(Long id) {//delete obj using id
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {//pagination using jpa
        return productRepository.findAll(pageable);
    }
    
    
    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> presentProduct = productRepository.findById(id);//get one obj using id
        if (presentProduct.isPresent()) {
        	
        	//check it present or not
            Product updatedProduct = presentProduct.get();
            
            //update it
            updatedProduct.setPname(product.getPname());
            updatedProduct.setCategory(product.getCategory());
            updatedProduct.setPrice(product.getPrice()); 
            updatedProduct.setQuantity(product.getQuantity()); 
            return productRepository.save(updatedProduct);
        } else {
            throw new RuntimeException("Product not found id: " + id);
        }
    }
}
