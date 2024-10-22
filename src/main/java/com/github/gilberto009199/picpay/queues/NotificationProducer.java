package com.github.gilberto009199.picpay.queues;

import com.github.gilberto009199.picpay.dto.NotificationDTO;
import com.github.gilberto009199.picpay.dto.TransactionDTO;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.tomcat.util.modeler.NotificationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Autowired
    private KafkaTemplate<String, TransactionDTO> producer;

    public void sendNotification(TransactionDTO transactionDTO){
        producer.send("transaction-notification", transactionDTO);
    }
}
