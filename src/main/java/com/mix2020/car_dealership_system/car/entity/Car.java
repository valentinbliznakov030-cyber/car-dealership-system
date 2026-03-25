package com.mix2020.car_dealership_system.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String brand;
    private String model;

    private Integer year;
    private Double price;
    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private CarStatus status;
}