package com.resonator.server.ambd.ambdservice.dao.entities;

import javax.persistence.*;

@Entity
@Table(name = "meta")
public class MetaEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="author")
    private String author;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ambd_id")
    private AmbdEntity ambdEntity;

    public MetaEntity() {
    }

    public MetaEntity(String name, String author) {
        this.name = name;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public AmbdEntity getAmbdEntity() {
        return ambdEntity;
    }

    public void setAmbdEntity(AmbdEntity ambdEntity) {
        this.ambdEntity = ambdEntity;
    }
}
