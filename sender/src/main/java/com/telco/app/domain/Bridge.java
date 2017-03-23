package com.telco.app.domain;

import com.telco.app.utils.State;

import javax.persistence.*;

@Entity
@Table(name = "bridges")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bridge bridge = (Bridge) o;

        if (name != null ? !name.equals(bridge.name) : bridge.name != null) return false;
        if (uuid != null ? !uuid.equals(bridge.uuid) : bridge.uuid != null) return false;
        return dataPathId != null ? dataPathId.equals(bridge.dataPathId) : bridge.dataPathId == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (dataPathId != null ? dataPathId.hashCode() : 0);
        return result;
    }
}
