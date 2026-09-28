package com.transaction.transaction_service.ai.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class AccountHistoryTool {

    @Tool(description = "Get account history and previous fraud information for an account")
    public String getAccountHistory(String accountId) {

        return """
                Account ID: %s
                Previous fraud alerts: 2
                Recent transactions: 8
                Account age: 10 days
                """.formatted(accountId);
    }
}