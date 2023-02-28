package com.innowise.DudeWhereIsMyCar.dto.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleTypeRequest {


    @Min(value = 1)
    private Long vehicleTypeId;

    @NotNull
    @NotBlank
    private String typeName;

}



