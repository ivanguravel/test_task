package com.telco.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BridgeDto {
    private long id;
    private String name;
    private String uuid;
    private String dataPathId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDataPathId() {
        return dataPathId;
    }

    public void setDataPathId(String dataPathId) {
        this.dataPathId = dataPathId;
    }


}
