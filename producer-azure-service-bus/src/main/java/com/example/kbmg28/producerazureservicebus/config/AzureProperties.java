package com.example.kbmg28.producerazureservicebus.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.azure")
public class AzureProperties {
    String tenantId;
    String clientId;
    String clientSecret;
    String endpoint; // eg: example.servicebus.windows.net
}