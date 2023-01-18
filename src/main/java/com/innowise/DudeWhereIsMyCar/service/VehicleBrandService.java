package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;

import java.util.List;

public interface VehicleBrandService {
    public List<VehicleBrand> getAllBrands();

    public VehicleBrand addBrand(VehicleBrand carBrand);

    public void removeBrand(VehicleBrand carBrand);
}
