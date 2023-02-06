package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.VehicleType;

import java.util.List;

public interface VehicleTypeService {
    List<VehicleType> saveAll( List<VehicleType> vehicleTypes);

    void deleteVehicleType(Long typeId);

    List<VehicleType> getAllVehicleTypes();
}