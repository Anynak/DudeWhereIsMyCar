package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;

import java.util.List;

public interface VehicleBrandService {
    List<VehicleBrand> getAllVehicleBrands();

    VehicleBrand addVehicleBrand(VehicleBrand vehicleBrand);

    void removeVehicleBrandById(Long vehicleBrandId);
}
