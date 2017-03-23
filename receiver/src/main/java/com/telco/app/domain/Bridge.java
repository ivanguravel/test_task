package com.telco.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "bridges")
public class Bridge {
    private long id;
    private String name;
    private String uuid;
    private String dataPathId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
