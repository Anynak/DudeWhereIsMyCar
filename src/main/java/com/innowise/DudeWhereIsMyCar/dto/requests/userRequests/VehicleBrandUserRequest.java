package com.innowise.DudeWhereIsMyCar.dto.requests.userRequests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleBrandUserRequest {

    @NotNull
    @Min(0)
    private Long vehicleBrandId;

}
