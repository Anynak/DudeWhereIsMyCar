package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.VehicleModel;

import java.util.List;

public interface VehicleModelService {
    List<VehicleModel> getAllVehicleModels();

    List<VehicleModel> addVehicleModels(List<VehicleModel> vehicleModels);

    void removeVehicleModelById(Long vehicleModelId);
}
