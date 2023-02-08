package com.innowise.DudeWhereIsMyCar.DTO.responceDTO;

import com.innowise.DudeWhereIsMyCar.model.VehicleBrand;
import lombok.Data;

@Data
public class VehicleModelResponse {

    private Long vehicleModelId;

    private String vehicleModelName;

    private VehicleBrand vehicleBrand;
}
