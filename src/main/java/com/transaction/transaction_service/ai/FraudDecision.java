package com.transaction.transaction_service.ai;

public record FraudDecision(
        String risk,
        String reason,
        String action
) {
}