package com.example.kbmg28.producerazureservicebus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageContentType {
    TEXT("text/plain"), JSON("application/json"), XML("application/xml");

    private final String messageType;
}
