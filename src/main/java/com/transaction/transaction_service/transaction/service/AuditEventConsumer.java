package com.transaction.transaction_service.transaction.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuditEventConsumer {
	
	@KafkaListener(topics="transactions" ,groupId="transaction-audit-consumer")
	public void consume(String message) {
		System.out.println("received message"  + message);
		
	}

}
