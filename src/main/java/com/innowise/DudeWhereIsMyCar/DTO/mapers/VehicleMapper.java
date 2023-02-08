package com.innowise.DudeWhereIsMyCar.DTO.mapers;

import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.VehicleRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.VehicleResponse;
import com.innowise.DudeWhereIsMyCar.model.Vehicle;

public interface VehicleMapper {
    Vehicle toVehicle(VehicleRequest request);

    VehicleResponse toVehicleResponse(Vehicle vehicle);
}
