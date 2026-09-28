package com.transaction.transaction_service.transaction.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.transaction_service.ai.FraudAgent;
import com.transaction.transaction_service.ai.FraudContext;
import com.transaction.transaction_service.ai.FraudDecision;
import com.transaction.transaction_service.transaction.entity.Transaction;

@Service
public class TransactionEventConsumer {
	
	 private final FraudAgent fraudAgent;
	 private final ObjectMapper objectMapper;
	 private final KafkaTemplate<String, String> kafkaTemplate;

	    public TransactionEventConsumer(FraudAgent fraudAgent,ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
	        this.fraudAgent = fraudAgent;
	        this.objectMapper = objectMapper;
			this.kafkaTemplate = kafkaTemplate;
	    }
	
	@KafkaListener(topics="transactions")
	@RetryableTopic(attempts = "4")
	public void consume(String message) throws Exception {
	

		 
		        System.out.println("received latest message " + message);

		        // processing logic
		        
		        throw new Exception();

		    } 
	}	

