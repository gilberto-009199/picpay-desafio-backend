package com.github.gilberto009199.picpay.services;

import com.github.gilberto009199.picpay.dto.AuthorizationDTO;
import com.github.gilberto009199.picpay.entities.TransactionEntity;
import com.github.gilberto009199.picpay.exceptions.UnathorizationTransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class TransactionAuthorizationService {
    private RestClient restClient;
    public TransactionAuthorizationService(RestClient.Builder builder){
        this.restClient = builder
            .baseUrl("https://util.devi.tools/api/v2/authorize")
            .build();
    }

    public boolean authorizationCreateTransaction(TransactionEntity entity){
        var res = restClient
            .get()
            .retrieve()
            .toEntity(AuthorizationDTO.class);

        var notHasError = !res.getStatusCode().isError();
        var bodyNotEmpty = res.hasBody();
        var authorized  = notHasError || bodyNotEmpty || !res.getBody().isAuthorized();

        if(!authorized) throw new UnathorizationTransactionException("Not Authorization  Transaction");

        return true;
    }
}
