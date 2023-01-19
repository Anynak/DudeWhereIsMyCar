package com.innowise.DudeWhereIsMyCar.dto.response;

import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;
import lombok.Data;

@Data
public class VehicleModelResponse {

    private Long vehicleModelId;

    private String vehicleModelName;

    private VehicleBrand vehicleBrand;
}
