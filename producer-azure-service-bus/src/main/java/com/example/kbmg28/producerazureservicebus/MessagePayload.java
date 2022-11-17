package com.example.kbmg28.producerazureservicebus;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MessagePayload {
    @NotEmpty
    private String queueName;

    @NotNull
    private Object message;

    private MessageContentType type;
}
