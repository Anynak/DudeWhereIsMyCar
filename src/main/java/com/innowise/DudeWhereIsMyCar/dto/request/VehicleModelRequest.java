package com.innowise.DudeWhereIsMyCar.dto.request;

import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleModelRequest {

    private Long vehicleModelId;

    @NotBlank
    @NotNull
    private String vehicleModelName;

    @NotBlank
    @NotNull
    private VehicleBrand vehicleBrand;
}
