package com.innowise.DudeWhereIsMyCar.vehicle;

public interface VehicleMapper {
    Vehicle toVehicle(VehicleRequest request);

    VehicleResponse toVehicleResponse(Vehicle vehicle);
}
