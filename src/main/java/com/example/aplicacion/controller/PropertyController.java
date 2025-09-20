package com.example.aplicacion.controller;

import com.example.aplicacion.model.Property;
import com.example.aplicacion.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService service;

    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Property> create(@Valid @RequestBody Property property) {
        return ResponseEntity.status(201).body(service.create(property));
    }

    @GetMapping
    public List<Property> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getOne(@PathVariable Long id) {
        Property property = service.getById(id).orElse(null);
        if (property == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(property);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> update(@PathVariable Long id, @Valid @RequestBody Property property) {
        Property updated = service.update(id, property).orElse(null);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
