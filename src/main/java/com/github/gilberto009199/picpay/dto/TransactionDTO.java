package com.github.gilberto009199.picpay.dto;

import com.github.gilberto009199.picpay.entities.TransactionEntity;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionDTO (
		Long id,
        @NotNull Long payer,
        @NotNull Long payee,
		@NotNull BigDecimal balance
){
    public static TransactionDTO ofTransactionEntity(TransactionEntity entity){
        return new TransactionDTO(
            entity.getId(),
            entity.getPayer(),
            entity.getPayee(),
            entity.getBalance());
    }
}
