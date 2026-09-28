package com.transaction.transaction_service.transaction.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.transaction_service.transaction.entity.OutboxEvent;


@Repository
public interface OutboxEventRepository extends JpaRepository<OutboxEvent,UUID> {

	List<OutboxEvent> findByPublishedFalse();

}
