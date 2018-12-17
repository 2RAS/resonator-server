package com.resonator.server.ambd.ambdservice.dao.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="ambd")
@Table(name = "ambd")
public class AmbdEntity {

    @Id
    @GeneratedValue
    @Column(name="ambd_id")
    private Long id;

    @Column(name = "triggers")
    ArrayList<TriggerEnum> triggers = new ArrayList<TriggerEnum>();

    @Column(name = "states")
    ArrayList<String> states = new ArrayList<String>();

    @Column(name = "transitions")
    ArrayList<String> transitions = new ArrayList<String>();

    @OneToOne(mappedBy = "ambdEntity", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private MetaEntity metaEntity;

    @OneToMany(
            mappedBy = "ambdEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PipelineEntity> pipelineEntities = new ArrayList<PipelineEntity>();

    @OneToMany(
            mappedBy = "ambdEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<StreamEntity> streamEntities = new ArrayList<>();

    public AmbdEntity() {
    }

    public AmbdEntity(MetaEntity metaEntity,
                      ArrayList<TriggerEnum> triggers,
                      ArrayList<String> states,
                      ArrayList<String> transitions,
                      List<PipelineEntity> pipelineEntities,
                      List<StreamEntity> streamEntities) {
        setMetaEntity(metaEntity);
        this.triggers = triggers;
        this.states = states;
        this.transitions = transitions;
        setPipelineEntities(pipelineEntities);
        setStreamEntities(streamEntities);
    }

    public void setMetaEntity(MetaEntity metaEntity) {
        if (metaEntity == null) {
            if (this.metaEntity != null) {
                this.metaEntity.setAmbdEntity(null);
            }
        }
        else {
            metaEntity.setAmbdEntity(this);
        }
        this.metaEntity = metaEntity;
    }

    public ArrayList<TriggerEnum> getTriggers() {
        return triggers;
    }

    public void setTriggers(ArrayList<TriggerEnum> triggers) {
        this.triggers = triggers;
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public void setStates(ArrayList<String> states) {
        this.states = states;
    }

    public ArrayList<String> getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList<String> transitions) {
        this.transitions = transitions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MetaEntity getMetaEntity() {
        return metaEntity;
    }

    public List<PipelineEntity> getPipelineEntities() {
        return pipelineEntities;
    }

    public void setPipelineEntities(List<PipelineEntity> pipelineEntities) {
        for(PipelineEntity pipelineEntity: pipelineEntities){
            addPipelineEntity(pipelineEntity);
        }
    }

    public List<StreamEntity> getStreamEntities() {
        return streamEntities;
    }

    public void setStreamEntities(List<StreamEntity> streamEntities) {
        for(StreamEntity streamEntity:streamEntities){
            addStreamEntity(streamEntity);
        }
    }

    public void addStreamEntity(StreamEntity streamEntity) {
        streamEntities.add(streamEntity);
        streamEntity.setAmbdEntity(this);
    }

    public void removeStreamEntityy(StreamEntity streamEntity) {
        streamEntities.remove(streamEntity);
        streamEntity.setAmbdEntity(null);
    }

    public void addPipelineEntity(PipelineEntity pipelineEntitie) {
        pipelineEntities.add(pipelineEntitie);
        pipelineEntitie.setAmbdEntity(this);
    }

    public void removePipelineEntity(PipelineEntity pipelineEntitie) {
        pipelineEntities.remove(pipelineEntitie);
        pipelineEntitie.setAmbdEntity(null);
    }

}
