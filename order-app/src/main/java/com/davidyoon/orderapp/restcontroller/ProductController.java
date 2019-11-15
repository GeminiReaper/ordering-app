package com.davidyoon.orderapp.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davidyoon.orderapp.model.OrderList;
import com.davidyoon.orderapp.model.Product;
import com.davidyoon.orderapp.repository.OrderListRepository;
import com.davidyoon.orderapp.repository.ProductRepository;

@RestController
public class ProductController {
	private final ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/products")
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }
 
    @PostMapping("/products")
    void addProducts(@RequestBody Product product) {
    	productRepository.save(product);
    } 
}
