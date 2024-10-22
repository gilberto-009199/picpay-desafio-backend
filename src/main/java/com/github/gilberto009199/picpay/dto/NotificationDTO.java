package com.github.gilberto009199.picpay.dto;

public record NotificationDTO(
    String status,
    NotificationDataDTO data
) {
    public boolean isSendMail(){
        return status.equals("success") && !data.message().isEmpty();
    }
}
