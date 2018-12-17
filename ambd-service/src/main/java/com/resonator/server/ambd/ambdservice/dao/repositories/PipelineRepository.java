package com.resonator.server.ambd.ambdservice.dao.repositories;

import com.resonator.server.ambd.ambdservice.dao.entities.PipelineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PipelineRepository extends
        JpaRepository<PipelineEntity, Long> {
}
