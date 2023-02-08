package com.innowise.DudeWhereIsMyCar.DTO.requestsDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleTypeRequest {

    @NotNull
    @Min(value = 1)
    private Long vehicleTypeId;

    @NotNull
    @NotBlank
    private String typeName;

}



