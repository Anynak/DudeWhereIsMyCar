package com.innowise.DudeWhereIsMyCar.dto.mapers;

import com.innowise.DudeWhereIsMyCar.dto.requests.VehicleRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.VehicleResponse;
import com.innowise.DudeWhereIsMyCar.models.Vehicle;

public interface VehicleMapper {
    Vehicle toVehicle(VehicleRequest request);

    VehicleResponse toVehicleResponse(Vehicle vehicle);
}
