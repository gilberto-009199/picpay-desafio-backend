package com.github.gilberto009199.picpay.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.gilberto009199.picpay.entities.WalletEntity;
import lombok.With;
import org.springframework.data.annotation.CreatedDate;

import com.github.gilberto009199.picpay.enums.WalletEnum;

public record WalletDTO(
	Long id,
	Long cpf,
	String name,
    String email,
	String password,
	WalletEnum type,
	BigDecimal balance,
	LocalDateTime createdAt
) {
    public static WalletDTO ofWalletEntity(WalletEntity entity){
        return new WalletDTO(entity.getId(),
                             entity.getCpf(),
                             entity.getName(),
                             entity.getPassword(),
                             entity.getEmail(),
                             entity.getType(),
                             entity.getBalance(),
                             entity.getCreatedAt());
    }
}
