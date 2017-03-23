package com.telco.app.dto;

public class BridgeDto {
    private String name;
    private String uuid;
    private String dataPathId;
    private String state;

    public BridgeDto() {
    }

    public BridgeDto(String name, String uuid, String dataPathId, String state) {
        this.name = name;
        this.uuid = uuid;
        this.dataPathId = dataPathId;
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setDataPathId(String dataPathId) {
        this.dataPathId = dataPathId;
    }

    public void setState(String state) {
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
