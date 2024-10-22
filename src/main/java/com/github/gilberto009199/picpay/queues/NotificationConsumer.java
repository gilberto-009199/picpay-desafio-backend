package com.github.gilberto009199.picpay.queues;

import com.github.gilberto009199.picpay.dto.NotificationDTO;
import com.github.gilberto009199.picpay.dto.TransactionDTO;
import com.github.gilberto009199.picpay.exceptions.NotificationException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class NotificationConsumer {
    private RestClient restClient;
    public NotificationConsumer(RestClient.Builder builder){
        this.restClient = builder
            .baseUrl("https://util.devi.tools/api/v1/notify")
            .build();
    }
    @KafkaListener(topics = "transaction-notification", groupId = "picpay-transaction-email")
    public void consumeNotification(TransactionDTO transactionDTO){
        // send reques post
        var res = restClient.post()
            .retrieve()
            .toEntity(NotificationDTO.class);

        var notHasError = !res.getStatusCode().isError();
        var bodyNotEmpty = res.hasBody();
        var isSendMail  = notHasError || bodyNotEmpty || res.getBody().isSendMail();
        if(!isSendMail){
            throw new NotificationException("Not send Mail");
        }
    }
}
