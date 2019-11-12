package com.davidyoon.orderapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.davidyoon.orderapp.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
