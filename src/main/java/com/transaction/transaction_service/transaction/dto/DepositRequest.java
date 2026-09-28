package com.transaction.transaction_service.transaction.dto;

import java.math.BigDecimal;

public record DepositRequest(
		String accountId,
		String currency,
		BigDecimal amount
		
		) {

}
