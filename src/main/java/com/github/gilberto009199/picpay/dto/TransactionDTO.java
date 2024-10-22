package com.github.gilberto009199.picpay.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO (
		Long id,
		Long payer,
        Long payee,
		BigDecimal value,
		LocalDateTime creaatedAt
){}
