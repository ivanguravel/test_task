package com.telco.app.service.parsing;

import com.telco.app.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BridgeMessageParsingStrategy implements MessageParsingStrategy {

    @Autowired
    private BridgeService service;

    @Override
    public boolean parse(final String payment) {
        return false;
    }
}
