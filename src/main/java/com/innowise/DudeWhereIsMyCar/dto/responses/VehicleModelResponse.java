package com.innowise.DudeWhereIsMyCar.dto.responses;

import com.innowise.DudeWhereIsMyCar.models.VehicleBrand;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleModelResponse {

    private Long vehicleModelId;

    private String vehicleModelName;

    private VehicleBrand vehicleBrand;
}
