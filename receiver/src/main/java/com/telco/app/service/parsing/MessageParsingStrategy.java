package com.telco.app.service.parsing;

public interface MessageParsingStrategy {
    boolean parse(final String payment);
}
