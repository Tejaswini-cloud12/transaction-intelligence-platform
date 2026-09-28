package com.transaction.transaction_service.ai;

public record FraudContext(
        int previousFraudAlerts,
        int recentTransactionCount,
        int accountAgeDays
) {
}