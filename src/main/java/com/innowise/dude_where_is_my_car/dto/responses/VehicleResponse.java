package com.innowise.dude_where_is_my_car.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleResponse {
    private Long vehicleId;
    private Integer mileage;
    private Integer releaseYear;
    private String color;
    private VehicleModelResponse vehicleModel;
}
