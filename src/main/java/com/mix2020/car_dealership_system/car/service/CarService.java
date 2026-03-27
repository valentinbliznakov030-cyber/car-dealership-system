package com.mix2020.car_dealership_system.car.service;

import com.mix2020.car_dealership_system.car.entity.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    Car createCar(Car car);

    List<Car> getAllCars();

    Car getCarById(UUID id);

    void deleteCar(UUID id);
}
