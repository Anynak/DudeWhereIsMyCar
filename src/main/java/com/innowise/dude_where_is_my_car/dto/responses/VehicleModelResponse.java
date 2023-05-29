package com.innowise.dude_where_is_my_car.dto.responses;

import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleModelResponse {

    private Long vehicleModelId;

    private String vehicleModelName;

    private VehicleBrand vehicleBrand;
}
