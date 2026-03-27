package com.mix2020.car_dealership_system.car.dto;

import com.mix2020.car_dealership_system.car.entity.Car;
import com.mix2020.car_dealership_system.car.entity.CarStatus;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
public class CarResponseDTO {
    private UUID id;
    private String brand;
    private String model;
    private Integer year;
    private Double price;
    private Integer mileage;
    private CarStatus status;

    public CarResponseDTO(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.year = car.getYear();
        this.price = car.getPrice();
        this.mileage = car.getMileage();
        this.status = car.getStatus();
    }
}
