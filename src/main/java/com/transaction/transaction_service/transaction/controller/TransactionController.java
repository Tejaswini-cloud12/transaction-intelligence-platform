package com.transaction.transaction_service.transaction.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.transaction_service.transaction.dto.DepositRequest;
import com.transaction.transaction_service.transaction.entity.Transaction;
import com.transaction.transaction_service.transaction.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionService transactionService;
	
	public TransactionController(TransactionService service) {
		this.transactionService=service;
	}
	
	@PostMapping
	public Transaction createTransaction(@Valid @RequestBody DepositRequest transaction) {
		return transactionService.createTransaction(transaction);
	}
}
