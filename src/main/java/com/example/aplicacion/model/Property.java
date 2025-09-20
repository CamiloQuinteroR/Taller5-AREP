/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.aplicacion.model;

/**
 *
 * @author Milo
 */


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String address;

    @NotNull
    @PositiveOrZero
    private Double price;

    @NotNull
    @Positive
    private Double size;

    @Column(length = 2000)
    private String description;

    public Property() {
    }

    public Property(String address, Double price, Double size, String description) {
        this.address = address;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


