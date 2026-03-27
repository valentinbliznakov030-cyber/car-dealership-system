package com.mix2020.car_dealership_system.car.service.impl;

import com.mix2020.car_dealership_system.car.entity.Car;
import com.mix2020.car_dealership_system.car.repository.CarRepository;
import com.mix2020.car_dealership_system.car.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(UUID id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }
}