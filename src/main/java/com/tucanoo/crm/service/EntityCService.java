package com.tucanoo.crm.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.tucanoo.crm.model.EntityC;
import com.tucanoo.crm.repository.EntityCRepository;
import com.tucanoo.crm.web.EntityCRequest;

@Service
public class EntityCService {
    private final EntityCRepository repository;

    public EntityCService(EntityCRepository repository) {
        this.repository = repository;
    }

    public EntityC create(EntityCRequest request) {
        EntityC entityC = new EntityC();
        entityC.setId(UUID.randomUUID().toString());
        entityC.setCategory(request.category());
        entityC.setDescription(request.description());
        entityC.setPriorityScore(request.priorityScore());
        entityC.setLastAccessedAt(Instant.now());
        return repository.save(entityC);
    }

    public Optional<EntityC> findById(String id) {
        return repository.findById(id);
    }
}
