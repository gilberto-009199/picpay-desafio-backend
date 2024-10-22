package com.github.gilberto009199.picpay.entities;

import java.math.BigDecimal;

import com.github.gilberto009199.picpay.dto.TransactionDTO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_TRANSACTIONS")
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long payer;
	Long payee;
	BigDecimal balance;
    public static TransactionEntity ofTransactionDTO(TransactionDTO dto){
        return new TransactionEntity()
            .withId(dto.id())
            .withPayee(dto.payee())
            .withPayer(dto.payer())
            .withBalance(dto.balance());
    }
}
