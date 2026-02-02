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
import com.tucanoo.crm.model.EntityB;
import com.tucanoo.crm.service.EntityBService;

@RestController
@RequestMapping("/api/entity-b")
public class EntityBController {
    private final EntityBService service;

    public EntityBController(EntityBService service) {
        this.service = service;
    }

    @PostMapping
    public EntityB create(@Validated @RequestBody EntityBRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityB> getById(@PathVariable String id) {
        Optional<EntityB> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
