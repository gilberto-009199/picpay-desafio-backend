package com.github.gilberto009199.picpay.dto;

public record AuthorizationDTO(
    String status,
    AuthorizationDataDTO data
){
    public boolean isAuthorized(){
        return status.equals("success") && data.authorization();
    }
}

