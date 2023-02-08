package com.innowise.DudeWhereIsMyCar.vehicleModel;

import com.innowise.DudeWhereIsMyCar.vehicleBrand.VehicleBrand;
import lombok.Data;

@Data
public class VehicleModelResponse {

    private Long vehicleModelId;

    private String vehicleModelName;

    private VehicleBrand vehicleBrand;
}
