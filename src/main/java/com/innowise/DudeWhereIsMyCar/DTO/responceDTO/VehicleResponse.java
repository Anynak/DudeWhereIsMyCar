package com.innowise.DudeWhereIsMyCar.DTO.responceDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleResponse {
    private Long vehicleId;
    private Integer mileage;
    private Integer releaseYear;
    private String color;
    private VehicleTypeResponse vehicleType;
    private VehicleModelResponse vehicleModel;
}
