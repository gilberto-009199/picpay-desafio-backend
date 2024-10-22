package com.github.gilberto009199.picpay.controllers;

import com.github.gilberto009199.picpay.dto.TransactionDTO;
import com.github.gilberto009199.picpay.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public TransactionDTO createTransaction(@RequestBody TransactionDTO dto){
        return service.create(dto);
    }

    @GetMapping
    public List<TransactionDTO> list(){
        return service.list();
    }

}
