package com.mix2020.car_dealership_system.car.service.impl;

import com.mix2020.car_dealership_system.car.dto.CarCreateRequestDTO;
import com.mix2020.car_dealership_system.car.dto.CarResponseDTO;
import com.mix2020.car_dealership_system.car.entity.Car;
import com.mix2020.car_dealership_system.car.entity.CarStatus;
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
    public CarResponseDTO createCar(CarCreateRequestDTO dto) {
        Car car = Car.builder()
                .brand(dto.getBrand())
                .model(dto.getModel())
                .year(dto.getYear())
                .price(dto.getPrice())
                .mileage(dto.getMileage())
                .status(CarStatus.AVAILABLE)
                .build();

        Car saved = carRepository.save(car);

        return CarResponseDTO.builder()
                .id(saved.getId())
                .brand(saved.getBrand())
                .model(saved.getModel())
                .price(saved.getPrice())
                .status(saved.getStatus())
                .build();
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