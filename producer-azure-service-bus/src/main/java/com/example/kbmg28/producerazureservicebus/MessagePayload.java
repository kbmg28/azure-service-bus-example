package com.example.kbmg28.producerazureservicebus;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MessagePayload {
    @NotEmpty
    private String queueName;

    @NotEmpty
    private String message;

    private MessageContentType type;
}
