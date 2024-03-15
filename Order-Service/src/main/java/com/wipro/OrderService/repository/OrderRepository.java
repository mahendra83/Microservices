package com.wipro.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.OrderService.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
