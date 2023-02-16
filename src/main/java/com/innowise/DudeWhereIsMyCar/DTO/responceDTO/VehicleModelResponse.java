package com.innowise.DudeWhereIsMyCar.DTO.responceDTO;

import com.innowise.DudeWhereIsMyCar.model.VehicleBrand;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleModelResponse {

    private Long vehicleModelId;

    private String vehicleModelName;

    private VehicleBrand vehicleBrand;
}
