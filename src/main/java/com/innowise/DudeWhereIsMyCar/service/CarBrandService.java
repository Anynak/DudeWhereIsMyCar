package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.CarBrand;

import java.util.List;

public interface CarBrandService {
    public List<CarBrand> getAllBrands();

    public CarBrand addBrand(CarBrand carBrand);

    public void removeBrand(CarBrand carBrand);
}
