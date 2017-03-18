package com.telco.app;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MessageHolder {

    private ConcurrentHashMap<String, Boolean> messages = new ConcurrentHashMap<>();

    public void addMessage(final String message) {
        messages.put(message, false);
    }

    Set<String> getMessages() {
        return new TreeSet<>(messages.keySet());
    }
}
