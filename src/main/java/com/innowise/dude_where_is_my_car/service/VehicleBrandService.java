package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.models.VehicleBrand;

import java.util.List;

public interface VehicleBrandService {

    VehicleBrand getVehicleBrandById(Long id);

    List<VehicleBrand> getAllVehicleBrands();

    List<VehicleBrand> addAllVehicleBrands(List<VehicleBrand> vehicleBrands);

    void removeVehicleBrandById(Long vehicleBrandId);

}
