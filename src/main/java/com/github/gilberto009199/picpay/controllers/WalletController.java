package com.github.gilberto009199.picpay.controllers;

import com.github.gilberto009199.picpay.dto.WalletDTO;
import com.github.gilberto009199.picpay.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping
    public List<WalletDTO> list(){
        return walletService.list();
    }

}
