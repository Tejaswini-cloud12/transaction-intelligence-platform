package com.transaction.transaction_service.transaction.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.transaction_service.transaction.entity.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,UUID> {

}
