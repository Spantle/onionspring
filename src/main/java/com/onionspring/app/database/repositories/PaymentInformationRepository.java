package com.onionspring.app.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onionspring.app.database.tables.PaymentInformation;

public interface PaymentInformationRepository extends JpaRepository<PaymentInformation, Integer> {

}