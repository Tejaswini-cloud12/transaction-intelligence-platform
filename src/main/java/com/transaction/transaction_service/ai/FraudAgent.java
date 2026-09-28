package com.transaction.transaction_service.ai;

import java.math.BigDecimal;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.transaction.transaction_service.transaction.entity.Transaction;

@Service
public class FraudAgent {
	
    private final ChatClient chatClient;
    
    public FraudAgent(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public FraudDecision  analyse(Transaction transaction,FraudContext context) {


        if (transaction.getAmount().compareTo(new BigDecimal("5000")) > 0) {
            return new FraudDecision(
                    "HIGH",
                    "Amount exceeds $5000",
                    "REVIEW"
            );
        }

        if (!transaction.getCurrency().equals("USD")) {
            return new FraudDecision(
                    "MEDIUM",
                    "Non-USD transaction",
                    "REVIEW"
            );
        }

        if (context.previousFraudAlerts() >= 2) {
            return new FraudDecision(
                    "HIGH",
                    "Customer has previous fraud alerts",
                    "REVIEW"
            );
        }
        if (context.accountAgeDays() < 30
                && context.recentTransactionCount() >= 5) {

            return new FraudDecision(
                    "HIGH",
                    "New account with high recent transaction activity",
                    "REVIEW"
            );
        }
        return new FraudDecision(
                "LOW",
                "Transaction is within normal limits",
                "ALLOW"
        );
    }
}