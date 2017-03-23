package com.telco.app.domain;

import com.telco.app.utils.State;

import javax.persistence.*;

@Entity
@Table(name = "bridges_new")
public class Bridge {
    private String name;
    private String uuid;
    private String dataPathId;
    private State state;

    @Id
    @Column(name = "NAME", nullable = false)
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

    @Enumerated(EnumType.ORDINAL)
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
