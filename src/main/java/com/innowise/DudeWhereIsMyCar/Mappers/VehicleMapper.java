package com.innowise.DudeWhereIsMyCar.Mappers;

import com.innowise.DudeWhereIsMyCar.dto.request.VehicleRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleResponse;
import com.innowise.DudeWhereIsMyCar.entity.Vehicle;

public interface VehicleMapper {
    Vehicle toVehicle(VehicleRequest request);

    VehicleResponse toVehicleResponse(Vehicle vehicle);
}
