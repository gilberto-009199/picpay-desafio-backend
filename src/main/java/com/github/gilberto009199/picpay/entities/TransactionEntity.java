package com.github.gilberto009199.picpay.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.gilberto009199.picpay.dto.TransactionDTO;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("tbl_transactions")
@Data
@With
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
	@Id
	Long id;
	Long payer;
	Long payee;
	BigDecimal value;
	@CreatedDate
	LocalDateTime createdAt;
    public static TransactionEntity ofTransactionDTO(TransactionDTO dto){
        return new TransactionEntity()
            .withId(dto.id())
            .withPayee(dto.payee())
            .withPayer(dto.payer());
    }
}
