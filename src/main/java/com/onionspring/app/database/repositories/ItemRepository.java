package com.onionspring.app.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    // this uses sorcery to function:
    // https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
}
