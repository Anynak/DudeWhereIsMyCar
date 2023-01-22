package com.innowise.DudeWhereIsMyCar.dto.request;

import com.innowise.DudeWhereIsMyCar.entity.VehicleModel;
import com.innowise.DudeWhereIsMyCar.entity.VehicleType;
import lombok.Data;

@Data
public class VehicleRequest {
    private Long vehicleId;
    private Integer mileage;
    private Integer releaseYear;
    private String color;
    private VehicleType vehicleType;
    private VehicleModel vehicleModel;

}
