package com.resonator.server.ambd.ambdservice.dao.repositories;

import com.resonator.server.ambd.ambdservice.dao.entities.MetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaRepository extends
        JpaRepository<MetaEntity, Long> {
}
