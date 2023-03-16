package com.innowise.DudeWhereIsMyCar.dto.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleModelRequest {

    private Long vehicleModelId;

    @NotBlank
    @NotNull
    private String vehicleModelName;
    @Valid
    @NotNull
    private VehicleBrandRequest vehicleBrand;

}
