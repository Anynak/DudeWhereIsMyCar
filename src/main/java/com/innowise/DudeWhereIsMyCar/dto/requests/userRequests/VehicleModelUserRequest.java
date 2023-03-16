package com.innowise.DudeWhereIsMyCar.dto.requests.userRequests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleModelUserRequest {
    @NotNull
    @Min(0)
    private Long vehicleModelId;

    @Valid
    @NotNull
    private VehicleBrandUserRequest vehicleBrand;
}
