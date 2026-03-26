package com.mix2020.car_dealership_system.car.repository;

import com.mix2020.car_dealership_system.car.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    Page<Car> findByBrand(String brand, Pageable pageable);
}