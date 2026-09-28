package com.transaction.transaction_service.transaction.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.transaction_service.transaction.entity.Transaction;


@Service
public class TransactionEventProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	
	
    public TransactionEventProducer(KafkaTemplate<String, String> kafkaTemplate,  ObjectMapper objectMapper ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }
    

    public void sendTransaction(Transaction transaction) {
    	 String message;
		 try {
			message = objectMapper.writeValueAsString(transaction);
			kafkaTemplate.send("transactions", message);
		 } catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }

       
    }
    
    
    public void send(String payload) {
        kafkaTemplate.send("transactions", payload);
    }
}
	
