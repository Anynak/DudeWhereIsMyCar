package com.innowise.DudeWhereIsMyCar.dto.response;

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
