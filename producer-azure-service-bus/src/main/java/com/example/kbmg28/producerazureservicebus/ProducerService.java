package com.example.kbmg28.producerazureservicebus;

import com.azure.core.amqp.exception.AmqpException;
import com.azure.identity.ClientSecretCredential;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.example.kbmg28.producerazureservicebus.config.AzureProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    private final ClientSecretCredential clientSecretCredential;
    private final AzureProperties azureProperties;

    public void sendMessage(MessagePayload messagePayload) {
        log.info("Payload: {}", messagePayload);
        if (Objects.isNull(messagePayload.getType())) {
            MessageContentType type = MessageContentType.JSON;
            log.info("type is null, using default type: {}", type);
            messagePayload.setType(type);
        }
        ServiceBusSenderClient senderClient = getServiceBusSenderClient(messagePayload);

        ServiceBusMessage msg = new ServiceBusMessage(messagePayload.getMessage());
        msg.setContentType(messagePayload.getType().getMessageType());

        log.info("Send message");
        try {
            senderClient.sendMessage(msg);
        } catch (AmqpException exception) {
            String message = exception.getMessage();
            exception.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message);
        }
        log.info("Message sent");

    }

    private ServiceBusSenderClient getServiceBusSenderClient(MessagePayload messagePayload) {
        // create a Service Bus Sender client for the queue
        return new ServiceBusClientBuilder()
                //.connectionString(connectionString)
                .credential(azureProperties.getEndpoint(), clientSecretCredential)
                .sender()
                .queueName(messagePayload.getQueueName())
                .buildClient();
    }
}
