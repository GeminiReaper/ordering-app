package com.davidyoon.orderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.davidyoon.orderapp.model.OrderList;

@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Long>{

}
