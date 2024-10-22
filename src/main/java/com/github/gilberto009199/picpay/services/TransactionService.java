package com.github.gilberto009199.picpay.services;

import com.github.gilberto009199.picpay.validators.TransactionValidator;
import com.github.gilberto009199.picpay.dto.TransactionDTO;
import com.github.gilberto009199.picpay.entities.TransactionEntity;
import com.github.gilberto009199.picpay.repositories.TransactionRepository;
import com.github.gilberto009199.picpay.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletRepository walletRepository;

    public TransactionDTO create(TransactionDTO dto){

        // validar parametro
        var walletPayer  = walletRepository.findById(dto.payer()).orElseThrow();
        var walletPayee  = walletRepository.findById(dto.payee()).orElseThrow();
        var transaction  = TransactionEntity.ofTransactionDTO(dto);

        var valid = TransactionValidator.validateCreateTransaction(transaction, walletPayer, walletPayee);
        if(!valid) throw new RuntimeException("Transaction InValid");

        // criar a transação
        var newTransaction = transactionRepository.save(transaction);

        // debitar da carteira
        walletRepository.save(walletPayer.withDebit(newTransaction.getValue()));

        // chamar autorizador

        // creditar na carteira alvo

        // enviar email via async jobs


        return null;
    }
}
