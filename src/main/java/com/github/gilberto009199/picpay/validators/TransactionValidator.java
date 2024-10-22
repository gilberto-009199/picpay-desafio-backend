package com.github.gilberto009199.picpay.validators;

import com.github.gilberto009199.picpay.entities.TransactionEntity;
import com.github.gilberto009199.picpay.entities.WalletEntity;
import com.github.gilberto009199.picpay.enums.WalletEnum;

import java.math.BigDecimal;

public class TransactionValidator {

    public static boolean validateCreateTransaction(TransactionEntity transaction, WalletEntity walletPayer, WalletEntity walletPayee){

        // 1. Não pode transferir para você mesmo (walletPayer == walletPayee)
        if(walletPayer.getId().equals(walletPayee.getId())) return false;

        // 2. Não pode transferir se o valor da transação for nulo ou menor/igual a zero
        if(transaction.getValue() == null || transaction.getValue().compareTo(BigDecimal.ZERO) <= 0) return false;

        // 3. Não pode transferir se a carteira pagadora (walletPayer) não tiver saldo suficiente
        if(walletPayer.getBalance() == null || walletPayer.getBalance().compareTo(transaction.getValue()) < 0)return false;

        // 4. Não pode transferir se a carteira pagadora (walletPayer) for uma carteira recebedora (walletPayee)
        if(walletPayer.getType().equals(WalletEnum.seller))return false;

        // 5. Não é possível fazer uma transferência com mais de 2 dígitos depois da vírgula
        if(transaction.getValue().scale() > 2)return false;

        return true;
    }

}
