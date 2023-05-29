package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.models.VehicleModel;

import java.util.List;

public interface VehicleModelService {
    List<VehicleModel> getAllVehicleModels();

    List<VehicleModel> addVehicleModels(List<VehicleModel> vehicleModels);

    void removeVehicleModelById(Long vehicleModelId);

    List<VehicleModel> getVehicleModelsByBrand(Long brandId);
}
