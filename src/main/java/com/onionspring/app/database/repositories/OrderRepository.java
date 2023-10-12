package com.onionspring.app.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}