package com.resonator.server.ambd.ambdservice.dao.entities;

import javax.persistence.*;

@Entity
@Table(name="stream_entity")
public class StreamEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="from_name")
    private String from_name;

    @Column(name="from_out")
    private String from_out;

    @Column(name="to_name")
    private String to_name;

    @Column(name="to_in")
    private String to_in;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambd_id")
    private AmbdEntity ambdEntity;

    public StreamEntity() {
    }

    public StreamEntity(String from_name, String from_out, String to_name, String to_in) {
        this.from_name = from_name;
        this.from_out = from_out;
        this.to_name = to_name;
        this.to_in = to_in;
    }

    public AmbdEntity getAmbdEntity() {
        return ambdEntity;
    }

    public void setAmbdEntity(AmbdEntity ambdEntity) {
        this.ambdEntity = ambdEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getFrom_out() {
        return from_out;
    }

    public void setFrom_out(String from_out) {
        this.from_out = from_out;
    }

    public String getTo_name() {
        return to_name;
    }

    public void setTo_name(String to_name) {
        this.to_name = to_name;
    }

    public String getTo_in() {
        return to_in;
    }

    public void setTo_in(String to_in) {
        this.to_in = to_in;
    }
}
