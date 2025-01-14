package com.bhagya.microservices.order_service.repository;

import com.bhagya.microservices.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
