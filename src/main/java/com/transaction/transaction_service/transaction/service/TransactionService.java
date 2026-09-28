package com.transaction.transaction_service.transaction.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.transaction.transaction_service.transaction.dto.DepositRequest;
import com.transaction.transaction_service.transaction.entity.OutboxEvent;
import com.transaction.transaction_service.transaction.entity.Transaction;
import com.transaction.transaction_service.transaction.entity.TransactionStatus;
import com.transaction.transaction_service.transaction.repository.OutboxEventRepository;
import com.transaction.transaction_service.transaction.repository.TransactionRepository;

@Service
public class TransactionService {

	
	private final TransactionRepository repository;
	private final TransactionEventProducer producer;
	private final OutboxEventRepository outboxEventRepository;
	
	
	public TransactionService(TransactionRepository repository,TransactionEventProducer producer,
			OutboxEventRepository outboxEventRepository) {
		this.repository=repository;
		this.producer=producer;
		this.outboxEventRepository = outboxEventRepository;
	}

	
	public Transaction createTransaction(DepositRequest request) {

	    Transaction transaction = new Transaction();

		  transaction.setAccountId(request.accountId());
		    transaction.setCurrency(request.currency());
		    transaction.setAmount(request.amount());
		    transaction.setStatus(TransactionStatus.PENDING);
		    transaction.setCreatedAt(Instant.now());

		    Transaction saved = repository.save(transaction);
		    OutboxEvent event = new OutboxEvent();
		    event.setAggregateId(saved.getTransaction_id().toString());
		    event.setEventType("TRANSACTION_CREATED");
		    event.setPayload(saved.getTransaction_id().toString());
		    event.setCreatedAt(Instant.now());
		    event.setPublished(false);

		    outboxEventRepository.save(event);

		//producer.sendTransaction(saved);
		return saved;
	}
	
	
}
