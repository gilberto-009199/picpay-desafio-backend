package com.github.gilberto009199.picpay.services;

import com.github.gilberto009199.picpay.exceptions.InvalidTransactionException;
import com.github.gilberto009199.picpay.validators.TransactionValidator;
import com.github.gilberto009199.picpay.dto.TransactionDTO;
import com.github.gilberto009199.picpay.entities.TransactionEntity;
import com.github.gilberto009199.picpay.repositories.TransactionRepository;
import com.github.gilberto009199.picpay.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransactionAuthorizationService authorizationService;
    @Autowired
    private NotificationService notificationService;

    @Transactional
    public TransactionDTO create(TransactionDTO dto){

        // validar parametro
        var walletPayer  = walletRepository.findById(dto.payer()).orElseThrow();
        var walletPayee  = walletRepository.findById(dto.payee()).orElseThrow();
        var transaction  = TransactionEntity.ofTransactionDTO(dto);

        var valid = TransactionValidator.validateCreateTransaction(transaction, walletPayer, walletPayee);
        if(!valid) throw new InvalidTransactionException("Transaction Invalid");

        // criar a transação
        var newTransaction = transactionRepository.save(transaction);

        // debitar da carteira
        walletRepository.save(walletPayer.withDebit(newTransaction.getValue()));

        // chamar autorizador
        authorizationService.authorizationCreateTransaction(newTransaction);

        // creditar na carteira alvo
        walletRepository.save(walletPayee.withCredit(newTransaction.getValue()));

        // enviar email via async jobs
        notificationService.notifyCreateTransaction(newTransaction);

        return TransactionDTO.ofTransactionEntity(newTransaction);
    }

    public List<TransactionDTO> list() {
        return transactionRepository.findAll()
            .stream()
            .map(TransactionDTO::ofTransactionEntity)
            .toList();
    }
}
