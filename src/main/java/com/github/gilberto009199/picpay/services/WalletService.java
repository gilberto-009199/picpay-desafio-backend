package com.github.gilberto009199.picpay.services;

import com.github.gilberto009199.picpay.dto.WalletDTO;
import com.github.gilberto009199.picpay.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;
    public List<WalletDTO> list(){
        return walletRepository.findAll()
            .stream()
            .map(WalletDTO::ofWalletEntity)
            .toList();
    }
}
