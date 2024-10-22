package com.github.gilberto009199.picpay.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.gilberto009199.picpay.dto.WalletDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.github.gilberto009199.picpay.enums.WalletEnum;

import jakarta.persistence.Entity;

@Table(name ="tbl_wallets")
@With
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletEntity {
	@Id
	Long id;
	Long cpf;
    String name;
    String email;
	String password;
    @Enumerated(EnumType.ORDINAL)
	WalletEnum type;
	BigDecimal balance;
	@CreatedDate
	LocalDateTime createdAt;

    public strictfp WalletEntity withCredit(BigDecimal value){
        this.balance = this.balance.add(value);
        return this;
    }

    public strictfp WalletEntity withDebit(BigDecimal value){
        this.balance = this.balance.subtract(value);
        return this;
    }

    public static WalletEntity ofWalletDto(WalletDTO dto){
        return new WalletEntity()
            .withId(dto.id())
            .withCpf(dto.cpf())
            .withName(dto.name())
            .withEmail(dto.email())
            .withPassword(dto.password())
            .withType(dto.type())
            .withBalance(dto.balance());
    }
}
