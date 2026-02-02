package com.tucanoo.crm.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.tucanoo.crm.model.EntityA;
import com.tucanoo.crm.repository.EntityARepository;
import com.tucanoo.crm.web.EntityARequest;

@Service
public class EntityAService {
    private final EntityARepository repository;

    public EntityAService(EntityARepository repository) {
        this.repository = repository;
    }

    public EntityA create(EntityARequest request) {
        EntityA entityA = new EntityA();
        entityA.setId(UUID.randomUUID().toString());
        entityA.setDisplayName(request.displayName());
        entityA.setStatus(request.status());
        entityA.setCreatedAt(Instant.now());
        entityA.setAccessCount(0L);
        return repository.save(entityA);
    }

    public Optional<EntityA> findById(String id) {
        return repository.findById(id);
    }
}
