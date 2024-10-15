package com.github.gilberto009199.picpay.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.github.gilberto009199.picpay.enums.WalletEnum;

public record WalletDTO(
	Long id,
	Long cpf,
	String name,
	String password,
	WalletEnum type,
	BigDecimal balance,
	LocalDateTime createdAt
) {}
