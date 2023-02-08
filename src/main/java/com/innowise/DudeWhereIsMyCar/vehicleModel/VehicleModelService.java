package com.innowise.DudeWhereIsMyCar.vehicleModel;

import java.util.List;

public interface VehicleModelService {
    List<VehicleModel> getAllVehicleModels();

    List<VehicleModel> addVehicleModels(List<VehicleModel> vehicleModels);

    void removeVehicleModelById(Long vehicleModelId);
}
