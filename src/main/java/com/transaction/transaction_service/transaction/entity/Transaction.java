package com.transaction.transaction_service.transaction.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID transaction_id;
	
	private UUID userId;
	private String accountId;
	private String currency;
	private BigDecimal amount;
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
	private Instant createdAt;
	
	public Transaction() {
		super();
	}
	public Transaction(UUID transaction_id, String userName, String accountId, String currency, BigDecimal amount,
			TransactionStatus status, Instant createdAt) {
		super();
		this.transaction_id = transaction_id;
		this.userId = userId;
		this.accountId = accountId;
		this.currency = currency;
		this.amount = amount;
		this.status = status;
		this.createdAt = createdAt;
	}
	public UUID getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(UUID transaction_id) {
		this.transaction_id = transaction_id;
	}
	public UUID getUserName() {
		return userId;
	}
	public void setUserName(UUID userId) {
		this.userId = userId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public TransactionStatus getStatus() {
		return status;
	}
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	

}
