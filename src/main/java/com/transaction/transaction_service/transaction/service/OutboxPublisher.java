package com.transaction.transaction_service.transaction.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.transaction.transaction_service.transaction.entity.OutboxEvent;
import com.transaction.transaction_service.transaction.repository.OutboxEventRepository;

@Service
public class OutboxPublisher {
	
	  private final OutboxEventRepository outboxRepository;
	    private final TransactionEventProducer producer;

	    public OutboxPublisher(
	            OutboxEventRepository outboxRepository,
	            TransactionEventProducer producer) {
	        this.outboxRepository = outboxRepository;
	        this.producer = producer;
	    }
	    
	    @Scheduled(fixedRate=5000)
	    public void publishEvents() {
	    	List<OutboxEvent> list=outboxRepository.findByPublishedFalse();
	    	
	    	
	    	for (OutboxEvent outboxEvent : list) {
	    		 producer.send(outboxEvent.getPayload());

	    		 outboxEvent.setPublished(true);

	             outboxRepository.save(outboxEvent);
			}
	    	
	    }


}
