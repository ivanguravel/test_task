package com.telco.app.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
