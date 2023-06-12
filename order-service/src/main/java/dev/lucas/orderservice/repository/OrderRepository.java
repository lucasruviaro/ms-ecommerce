package dev.lucas.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lucas.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
