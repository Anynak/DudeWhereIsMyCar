package com.innowise.DudeWhereIsMyCar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleBrandRequest {

    private Long vehicleBrandId;

    @NotBlank
    @NotNull
    private String vehicleBrandName;
}
