package com.onionspring.app.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.Order;
import com.onionspring.app.database.tables.User;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
}