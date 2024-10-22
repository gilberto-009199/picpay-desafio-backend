package com.github.gilberto009199.picpay.entities;

import java.math.BigDecimal;

import com.github.gilberto009199.picpay.converters.WalletEnumConverter;
import com.github.gilberto009199.picpay.dto.WalletDTO;
import jakarta.persistence.*;
import lombok.*;

import com.github.gilberto009199.picpay.enums.WalletEnum;

@Entity
@Table(name ="TBL_WALLETS")
@With
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long cpf;
    String name;
    String email;
	String password;
    @Convert(converter = WalletEnumConverter.class)
    WalletEnum type;
	BigDecimal balance;

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
