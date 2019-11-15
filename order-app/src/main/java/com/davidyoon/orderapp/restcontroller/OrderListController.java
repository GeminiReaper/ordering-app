package com.davidyoon.orderapp.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davidyoon.orderapp.model.OrderList;
import com.davidyoon.orderapp.repository.OrderListRepository;

@RestController
public class OrderListController {
	
	private final OrderListRepository orderListRepository;
	
	public OrderListController(OrderListRepository orderListRepository) {
		this.orderListRepository = orderListRepository;
	}
	
	@GetMapping("/orders")
    public List<OrderList> getOrders() {
        return (List<OrderList>) orderListRepository.findAll();
    }
 
    @PostMapping("/orders")
    public OrderList addOrder(@RequestBody OrderList orderList) {
    	
    	System.out.println(orderList.toString());
    	if(orderList.getCreationDate() == null) {
    		orderList.setCreationDate(LocalDateTime.now());
    	}
    	
    	return orderListRepository.save(orderList);
    } 
}
