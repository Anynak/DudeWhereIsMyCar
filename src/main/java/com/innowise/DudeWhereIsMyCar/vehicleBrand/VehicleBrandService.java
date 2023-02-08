package com.innowise.DudeWhereIsMyCar.vehicleBrand;

import java.util.List;

public interface VehicleBrandService {
    List<VehicleBrand> getAllVehicleBrands();

    List<VehicleBrand> addAllVehicleBrands(List<VehicleBrand> vehicleBrands);

    void removeVehicleBrandById(Long vehicleBrandId);

}
