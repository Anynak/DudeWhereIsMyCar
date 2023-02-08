package com.innowise.DudeWhereIsMyCar.vehicle;

import com.innowise.DudeWhereIsMyCar.vehicleModel.VehicleModelResponse;
import com.innowise.DudeWhereIsMyCar.vehicleType.VehicleTypeResponse;
import lombok.Data;

@Data
public class VehicleResponse {
    private Long vehicleId;
    private Integer mileage;
    private Integer releaseYear;
    private String color;
    private VehicleTypeResponse vehicleType;
    private VehicleModelResponse vehicleModel;
}
