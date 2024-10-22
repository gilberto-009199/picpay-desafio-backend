package com.github.gilberto009199.picpay.controllers;

import com.github.gilberto009199.picpay.dto.TransactionDTO;
import com.github.gilberto009199.picpay.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public TransactionDTO createTransaction(@RequestBody @Valid TransactionDTO dto){
        return transactionService.create(dto);
    }

    @GetMapping
    public List<TransactionDTO> list(){
        return transactionService.list();
    }

}
