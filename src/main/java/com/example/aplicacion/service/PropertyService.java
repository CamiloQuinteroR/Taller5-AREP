package com.example.aplicacion.service;

import com.example.aplicacion.model.Property;
import com.example.aplicacion.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepository repo;

    public PropertyService(PropertyRepository repo) {
        this.repo = repo;
    }

    public Property create(Property property) {
        return repo.save(property);
    }

    public List<Property> getAll() {
        return repo.findAll();
    }

    public Optional<Property> getById(Long id) {
        return repo.findById(id);
    }

    public Optional<Property> update(Long id, Property property) {
        return repo.findById(id).map(existing -> {
            existing.setAddress(property.getAddress());
            existing.setPrice(property.getPrice());
            existing.setSize(property.getSize());
            existing.setDescription(property.getDescription());
            return repo.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
