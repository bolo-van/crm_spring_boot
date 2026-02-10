package com.tucanoo.crm.web;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tucanoo.crm.model.EntityA;
import com.tucanoo.crm.service.EntityAService;

@RestController
@RequestMapping("/api/entity-a")
public class EntityAController {
    private final EntityAService service;

    public EntityAController(EntityAService service) {
        this.service = service;
    }

    @PostMapping
    public EntityA create(@Validated @RequestBody EntityARequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityA> getById(@PathVariable String id) {
        Optional<EntityA> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
