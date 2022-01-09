package com.davidyoon.orderapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidyoon.orderapp.model.OrderedProduct;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Long> {
	
}
