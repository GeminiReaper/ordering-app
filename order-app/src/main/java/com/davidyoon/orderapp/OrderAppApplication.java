package com.davidyoon.orderapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.davidyoon.orderapp.model.Order;
import com.davidyoon.orderapp.repository.OrderRepository;

@SpringBootApplication
public class OrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class, args);
	}
	
}
