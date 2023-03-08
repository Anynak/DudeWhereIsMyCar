package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.models.VehicleModel;

import java.util.List;

public interface VehicleModelService {
    List<VehicleModel> getAllVehicleModels();

    List<VehicleModel> addVehicleModels(List<VehicleModel> vehicleModels);

    void removeVehicleModelById(Long vehicleModelId);

    List<VehicleModel> getVehicleModelsByBrand(Long brandId);
}
