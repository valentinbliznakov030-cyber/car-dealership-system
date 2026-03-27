package com.mix2020.car_dealership_system.car.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarCreateRequestDTO {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Integer year;

    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    @Min(0)
    private Integer mileage;
}
