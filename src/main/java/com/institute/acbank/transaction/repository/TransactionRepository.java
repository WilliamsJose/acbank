package com.institute.acbank.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.institute.acbank.transaction.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
