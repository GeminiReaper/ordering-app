package com.davidyoon.orderapp.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davidyoon.orderapp.model.OrderList;
import com.davidyoon.orderapp.model.OrderedProduct;
import com.davidyoon.orderapp.repository.OrderedProductRepository;

@RestController
public class OrderedProductController {
	
	private final OrderedProductRepository orderedProductRepository;
	
	public OrderedProductController(OrderedProductRepository orderedProductRepository) {
		this.orderedProductRepository = orderedProductRepository;
	}
	
	@GetMapping("/orders/{orderId}/orderedProducts")
    public List<OrderedProduct> getOrderedProducts(@PathVariable long orderId) {
        
        
        return (List<OrderedProduct>) orderedProductRepository.findAll().stream()
															  .filter((order) -> order.getOrderList().getOrderListId() != orderId)
															  .collect(Collectors.toList());
    }
	
	@GetMapping("/orderedProducts")
	public List<OrderedProduct> getAllOrderedProducts() {
		return (List<OrderedProduct>) orderedProductRepository.findAll();
	}
	
 
    @PostMapping("/orders/{orderId}/orderedProducts")
    public List<OrderedProduct> addOrderedProducts(@RequestBody List<OrderedProduct> orderedProduct) {
    	orderedProduct.stream().forEach((op) -> orderedProductRepository.save(op));
    	
    	return orderedProduct;
    } 
}
