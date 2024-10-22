package com.github.gilberto009199.picpay.services;

import com.github.gilberto009199.picpay.dto.TransactionDTO;
import com.github.gilberto009199.picpay.entities.TransactionEntity;
import com.github.gilberto009199.picpay.queues.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private NotificationProducer notificationProducer;
    public void notifyCreateTransaction(TransactionEntity newTransaction) {
        notificationProducer.sendNotification(TransactionDTO.ofTransactionEntity(newTransaction));
    }
}
