package com.onionspring.app.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {

}