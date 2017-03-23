package com.telco.app.dto;

public class BridgeDto {
    private final String name;
    private final String uuid;
    private final String dataPathId;
    private final String state;

    public BridgeDto(String name, String uuid, String dataPathId, String state) {
        this.name = name;
        this.uuid = uuid;
        this.dataPathId = dataPathId;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getDataPathId() {
        return dataPathId;
    }

    public String getState() {
        return state;
    }
}
