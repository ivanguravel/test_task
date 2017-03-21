package com.concretepage.rabbitmq;

import com.concretepage.rabbitmq.receivers.DataHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Autowired
    @Qualifier("bridgeDataHandler")
    private DataHandler bridgeDataHandler;

    @Scheduled(fixedRate = 10_000)
    public void sendMessage() {
        bridgeDataHandler.handle();
    }
}

