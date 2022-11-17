package com.example.kbmg28.producerazureservicebus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageContentType {
    JSON("application/json"), TEXT("text/plain"), XML("application/xml");

    private final String messageType;
}
