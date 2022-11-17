package com.example.kbmg28.producerazureservicebus.config;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AzureClientConfig {
    private final AzureProperties azureProperties;

    @Bean
    public ClientSecretCredential clientSecretCredentialResolver() {
        return new ClientSecretCredentialBuilder()
                .tenantId(azureProperties.getTenantId())
                .clientId(azureProperties.getClientId())
                .clientSecret(azureProperties.getClientSecret())
                .build();
    }
}
