package com.mix2020.car_dealership_system.car.service.impl;

import com.mix2020.car_dealership_system.car.dto.CarCreateRequestDTO;
import com.mix2020.car_dealership_system.car.dto.CarResponseDTO;
import com.mix2020.car_dealership_system.car.entity.Car;
import com.mix2020.car_dealership_system.car.entity.CarStatus;
import com.mix2020.car_dealership_system.car.repository.CarRepository;
import com.mix2020.car_dealership_system.car.service.CarService;
import com.mix2020.car_dealership_system.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

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
    public List<CarResponseDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CarResponseDTO getCarById(UUID id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found"));

        return mapToResponse(car);
    }

    @Override
    public void deleteCar(UUID id) {
        carRepository.deleteById(id);
    }

    private CarResponseDTO mapToResponse(Car car) {
        return CarResponseDTO.builder()
                    .id(car.getId())
                    .brand(car.getBrand())
                    .model(car.getModel())
                    .year(car.getYear())
                    .price(car.getPrice())
                    .mileage(car.getMileage())
                    .status(car.getStatus())
                .build();
    }
}