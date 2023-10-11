package com.onionspring.app.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}