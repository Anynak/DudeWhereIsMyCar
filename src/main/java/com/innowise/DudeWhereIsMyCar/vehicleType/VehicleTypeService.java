package com.innowise.DudeWhereIsMyCar.vehicleType;

import java.util.List;

public interface VehicleTypeService {
    List<VehicleType> saveAll( List<VehicleType> vehicleTypes);

    void deleteVehicleType(Long typeId);

    List<VehicleType> getAllVehicleTypes();
}
