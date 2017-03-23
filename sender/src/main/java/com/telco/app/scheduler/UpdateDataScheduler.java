package com.telco.app.scheduler;

import com.telco.app.service.handler.DataHandlerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateDataScheduler {

    @Autowired
    private List<DataHandlerService> dataHandlers;

    @Scheduled(fixedRate = 10_000)
    public void updateData() {
        for (DataHandlerService dataHandler : dataHandlers) {
            dataHandler.handle();
        }
    }
}

