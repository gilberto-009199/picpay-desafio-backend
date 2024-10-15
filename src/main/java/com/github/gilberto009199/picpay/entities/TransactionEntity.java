package com.github.gilberto009199.picpay.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



import lombok.Builder;
import lombok.Data;

@Table("tbl_transactions")
@Data
@Builder
public class TransactionEntity {
	@Id
	Long id;
	Long payer;
	Long payee;
	BigDecimal value;
	@CreatedDate
	LocalDateTime createdAt;
}
