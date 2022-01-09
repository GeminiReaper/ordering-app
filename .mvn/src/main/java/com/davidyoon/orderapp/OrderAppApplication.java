package com.davidyoon.orderapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.davidyoon.orderapp.model.OrderList;
import com.davidyoon.orderapp.model.OrderedProduct;
import com.davidyoon.orderapp.model.Product;
import com.davidyoon.orderapp.repository.OrderListRepository;

@SpringBootApplication
public class OrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class, args);
	}
	
}
