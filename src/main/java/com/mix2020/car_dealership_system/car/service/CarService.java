package com.mix2020.car_dealership_system.car.service;

import com.mix2020.car_dealership_system.car.dto.CarCreateRequestDTO;
import com.mix2020.car_dealership_system.car.dto.CarResponseDTO;
import com.mix2020.car_dealership_system.car.entity.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    CarResponseDTO createCar(CarCreateRequestDTO dto);

    List<CarResponseDTO> getAllCars();
    CarResponseDTO getCarById(UUID id);

    void deleteCar(UUID id);
}
