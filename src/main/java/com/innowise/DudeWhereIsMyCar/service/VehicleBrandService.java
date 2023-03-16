package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.models.VehicleBrand;

import java.util.List;

public interface VehicleBrandService {

    VehicleBrand getVehicleBrandById(Long id);

    List<VehicleBrand> getAllVehicleBrands();

    List<VehicleBrand> addAllVehicleBrands(List<VehicleBrand> vehicleBrands);

    void removeVehicleBrandById(Long vehicleBrandId);

}
