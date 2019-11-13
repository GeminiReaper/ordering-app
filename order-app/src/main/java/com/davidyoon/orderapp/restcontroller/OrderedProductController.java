package com.davidyoon.orderapp.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
@CrossOrigin(origins = "http://localhost:4200")
public class OrderedProductController {
	
	private final OrderedProductRepository orderedProductRepository;
	
	public OrderedProductController(OrderedProductRepository orderedProductRepository) {
		this.orderedProductRepository = orderedProductRepository;
	}
	
	@GetMapping("/{orderId}/orderedProducts")
    public List<OrderedProduct> getOrderedProducts(@PathVariable long orderId) {
        
        
        return (List<OrderedProduct>) orderedProductRepository.findAll().stream()
															  .filter((order) -> order.getOrderList().getOrderListId() != orderId)
															  .collect(Collectors.toList());
    }
 
    @PostMapping("/{orderId}/orderedProducts")
    void addOrderedProduct(@RequestBody OrderedProduct orderedProduct) {
    	orderedProductRepository.save(orderedProduct);
    } 
}
