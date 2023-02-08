package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.model.VehicleModel;

import java.util.List;

public interface VehicleModelService {
    List<VehicleModel> getAllVehicleModels();

    List<VehicleModel> addVehicleModels(List<VehicleModel> vehicleModels);

    void removeVehicleModelById(Long vehicleModelId);
}
