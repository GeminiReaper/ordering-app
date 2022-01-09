package com.davidyoon.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidyoon.orderapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
