package com.resonator.server.ambd.ambdservice.dao.repositories;
import com.resonator.server.ambd.ambdservice.dao.entities.AmbdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbdRepository extends
        JpaRepository<AmbdEntity, Long> {
}
