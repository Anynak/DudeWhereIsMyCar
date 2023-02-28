package com.innowise.DudeWhereIsMyCar.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VehicleTypeResponse {
    private Long vehicleTypeId;

    private String typeName;
}
