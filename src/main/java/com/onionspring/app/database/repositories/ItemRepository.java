package com.onionspring.app.database.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByName(String name);
}