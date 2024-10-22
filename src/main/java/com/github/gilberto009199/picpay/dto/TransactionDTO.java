package com.github.gilberto009199.picpay.dto;

import com.github.gilberto009199.picpay.entities.TransactionEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO (
		Long id,
		Long payer,
        Long payee,
		BigDecimal value,
		LocalDateTime createdAt
){
    public static TransactionDTO ofTransactionEntity(TransactionEntity entity){
        return new TransactionDTO(
            entity.getId(),
            entity.getPayer(),
            entity.getPayee(),
            entity.getValue(),
            entity.getCreatedAt());
    }
}
