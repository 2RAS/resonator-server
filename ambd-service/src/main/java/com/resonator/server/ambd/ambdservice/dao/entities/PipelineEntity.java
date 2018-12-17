package com.resonator.server.ambd.ambdservice.dao.entities;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Table(name = "pipeline")
public class PipelineEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "config")
    private HashMap<String, String> config = new HashMap<String, String>();

    @Column(name = "interfaces_in")
    private HashMap<String, String> interfacesIn = new HashMap<String, String>();

    @Column(name = "interfaces_out")
    private HashMap<String, String> interfacesOut = new HashMap<String, String>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambd_id")
    private AmbdEntity ambdEntity;

    public PipelineEntity() {
    }

    public PipelineEntity(String name, String type, HashMap<String, String> config,
                          HashMap<String, String> interfacesIn,
                          HashMap<String, String> interfacesOut) {
        this.name = name;
        this.type = type;
        this.config = config;
        this.interfacesIn = interfacesIn;
        this.interfacesOut = interfacesOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getConfig() {
        return config;
    }

    public void setConfig(HashMap<String, String> config) {
        this.config = config;
    }

    public HashMap<String, String> getInterfacesIn() {
        return interfacesIn;
    }

    public void setInterfacesIn(HashMap<String, String> interfacesIn) {
        this.interfacesIn = interfacesIn;
    }

    public HashMap<String, String> getInterfacesOut() {
        return interfacesOut;
    }

    public void setInterfacesOut(HashMap<String, String> interfacesOut) {
        this.interfacesOut = interfacesOut;
    }

    public AmbdEntity getAmbdEntity() {
        return ambdEntity;
    }

    public void setAmbdEntity(AmbdEntity ambdEntity) {
        this.ambdEntity = ambdEntity;
    }
}
