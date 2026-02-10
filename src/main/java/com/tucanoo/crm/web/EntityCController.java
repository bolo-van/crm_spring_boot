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
import com.tucanoo.crm.model.EntityC;
import com.tucanoo.crm.service.EntityCService;

@RestController
@RequestMapping("/api/entity-c")
public class EntityCController {
    private final EntityCService service;

    public EntityCController(EntityCService service) {
        this.service = service;
    }

    @PostMapping
    public EntityC create(@Validated @RequestBody EntityCRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityC> getById(@PathVariable String id) {
        Optional<EntityC> result = service.findById(id);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
