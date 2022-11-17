package com.example.kbmg28.producerazureservicebus;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @PostMapping("/produce")
    public void sendMessage(@Valid @RequestBody MessagePayload messagePayload) {
        producerService.sendMessage(messagePayload);
    }
}
