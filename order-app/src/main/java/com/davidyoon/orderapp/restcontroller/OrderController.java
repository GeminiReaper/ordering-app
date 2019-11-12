package com.davidyoon.orderapp.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davidyoon.orderapp.model.Order;
import com.davidyoon.orderapp.repository.OrderRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	private final OrderRepository orderRepository;
	
	public OrderController(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@GetMapping("/orders")
    public List<Order> getUsers() {
        return (List<Order>) orderRepository.findAll();
    }
 
    @PostMapping("/orders")
    void addUser(@RequestBody Order order) {
    	orderRepository.save(order);
    } 
}
