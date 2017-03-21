package com.telco.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/broker-messages")
public class MessageBrokerController {

    @Autowired
    private MessageHolder messageHolder;

    @RequestMapping(method = RequestMethod.GET)
    public String getContent() {
        return messageHolder.getMessages().toString();
    }
}
