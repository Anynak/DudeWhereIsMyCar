package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;
import com.innowise.DudeWhereIsMyCar.repositories.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleBrandServiceImpl implements VehicleBrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<VehicleBrand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public VehicleBrand addBrand(VehicleBrand vehicleBrand) {
        return brandRepository.save(vehicleBrand);
    }

    @Override
    public void removeBrand(VehicleBrand vehicleBrand) {
        brandRepository.delete(vehicleBrand);
    }
}
