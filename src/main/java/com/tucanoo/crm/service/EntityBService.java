package com.tucanoo.crm.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.tucanoo.crm.model.EntityB;
import com.tucanoo.crm.repository.EntityBRepository;
import com.tucanoo.crm.web.EntityBRequest;

@Service
public class EntityBService {
    private final EntityBRepository repository;

    public EntityBService(EntityBRepository repository) {
        this.repository = repository;
    }

    public EntityB create(EntityBRequest request) {
        EntityB entityB = new EntityB();
        entityB.setId(UUID.randomUUID().toString());
        entityB.setTitle(request.title());
        entityB.setAmount(request.amount());
        entityB.setActive(request.active());
        entityB.setUpdatedAt(Instant.now());
        entityB.setAccessCount(0L);
        return repository.save(entityB);
    }

    public Optional<EntityB> findById(String id) {
        return repository.findById(id);
    }
}
