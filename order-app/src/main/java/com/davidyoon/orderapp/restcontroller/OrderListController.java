package com.davidyoon.orderapp.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.davidyoon.orderapp.model.OrderList;
import com.davidyoon.orderapp.repository.OrderListRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    void addOrder(@RequestBody OrderList orderList) {
    	orderListRepository.save(orderList);
    } 
}
