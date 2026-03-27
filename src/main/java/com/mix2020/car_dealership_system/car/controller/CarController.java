package com.mix2020.car_dealership_system.car.controller;

import com.mix2020.car_dealership_system.car.dto.CarCreateRequestDTO;
import com.mix2020.car_dealership_system.car.dto.CarResponseDTO;
import com.mix2020.car_dealership_system.car.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public CarResponseDTO createCar(@Valid @RequestBody CarCreateRequestDTO dto) {
        return carService.createCar(dto);
    }

    @GetMapping
    public List<CarResponseDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarResponseDTO getCarById(@PathVariable UUID id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable UUID id) {
        carService.deleteCar(id);
    }
}