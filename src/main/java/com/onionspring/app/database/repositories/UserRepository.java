package com.onionspring.app.database.repositories;

import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Future<User> findByEmail(String email);
}