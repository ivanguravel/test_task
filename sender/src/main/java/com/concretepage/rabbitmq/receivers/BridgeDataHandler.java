package com.concretepage.rabbitmq.receivers;

import com.concretepage.rabbitmq.SocketIO;

import com.concretepage.rabbitmq.dto.Bridge;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BridgeDataHandler implements DataHandler {

    @Value("${v_switch.start.query}")
    private String startQuery;
    @Value("${v_switch.bridges.by.name}")
    private String bridgesInfoByName;

    @Autowired
    private SocketIO socketIO;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void handle() {
        String responseWithBridgeName = socketIO.writeAndGetResponse(startQuery);
        try {
            Bridge bridge = objectMapper.readValue(responseWithBridgeName, Bridge.class);
            bridge.getConfiguredBridges().forEach(bridgeName -> {
                String response = socketIO.writeAndGetResponse(String.format(bridgesInfoByName, bridgeName));
                System.out.println("Message has been sent");
                rabbitTemplate.convertAndSend("test", response);
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
