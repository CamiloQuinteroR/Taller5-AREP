package com.example.aplicacion.repository;

import com.example.aplicacion.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    
}
