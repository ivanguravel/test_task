package com.telco.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BridgeNamesDto {
    @JsonProperty("result")
    private List<String> configuredBridges;

    public List<String> getConfiguredBridges() {
        return configuredBridges;
    }

    public void setConfiguredBridges(List<String> configuredBridges) {
        this.configuredBridges = configuredBridges;
    }
}
