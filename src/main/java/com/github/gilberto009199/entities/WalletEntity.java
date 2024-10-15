package com.github.gilberto009199.picpay.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.github.gilberto009199.picpay.enums.WalletEnum;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Table(name ="tbl_wallets")
@Data
@Builder
public class WalletEntity {
	@Id
	Long id;
	Long cpf;
	String name;
	String password;
	WalletEnum type;
	BigDecimal balance;
	@CreatedDate
	LocalDateTime createdAt;
}
