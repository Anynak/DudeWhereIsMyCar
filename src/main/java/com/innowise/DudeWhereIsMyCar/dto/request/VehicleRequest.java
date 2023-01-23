package com.innowise.DudeWhereIsMyCar.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleRequest {
    private Long vehicleId;

    @Min(value = 0)
    private Integer mileage = 0;

    @NotNull
    @Min(1886)
    private Integer releaseYear;

    @NotNull
    @NotBlank
    private String color;

    @NotNull
    private VehicleTypeRequest vehicleType;

    @NotNull
    private VehicleModelRequest vehicleModel;

}
