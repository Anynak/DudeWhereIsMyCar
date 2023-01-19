package com.innowise.DudeWhereIsMyCar.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleModelRequest {

    private Long vehicleModelId;

    @NotBlank
    @NotNull
    private String vehicleModelName;

    @NotNull
    private VehicleBrandRequest vehicleBrand;
}
