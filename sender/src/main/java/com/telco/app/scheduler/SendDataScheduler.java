package com.telco.app.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.telco.app.dto.BridgeDto;
import com.telco.app.service.BridgeService;
import com.telco.app.service.CustomObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SendDataScheduler {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private BridgeService service;
    @Autowired
    private CustomObjectMapper objectMapper;

    @Scheduled(fixedRate = 20_000)
    public void updateData() throws JsonProcessingException {
        List<BridgeDto> bridges = service.findAll();
        System.err.println("Message has been sent");
        rabbitTemplate.convertAndSend("test", objectMapper.writeValueAsString(bridges));
    }
}
