package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.model.VehicleBrand;

import java.util.List;

public interface VehicleBrandService {
    List<VehicleBrand> getAllVehicleBrands();

    List<VehicleBrand> addAllVehicleBrands(List<VehicleBrand> vehicleBrands);

    void removeVehicleBrandById(Long vehicleBrandId);

}
