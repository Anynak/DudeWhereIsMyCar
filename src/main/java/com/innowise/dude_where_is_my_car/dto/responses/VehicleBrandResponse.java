package com.innowise.dude_where_is_my_car.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleBrandResponse {
    private Long vehicleBrandId;
    private String vehicleBrandName;
}

