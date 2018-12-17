package com.resonator.server.ambd.ambdservice.dao.repositories;

import com.resonator.server.ambd.ambdservice.dao.entities.StreamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamRepository extends
        JpaRepository<StreamEntity, Long> {
}
