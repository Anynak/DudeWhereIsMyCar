package com.innowise.dude_where_is_my_car.dto.requests.user_requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehicleBrandUserRequest {

    @NotNull
    @Min(0)
    private Long vehicleBrandId;

}
