package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.models.VehicleBrand;
import com.innowise.DudeWhereIsMyCar.repositories.VehicleBrandRepository;
import com.innowise.DudeWhereIsMyCar.service.VehicleBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleBrandServiceImpl implements VehicleBrandService {
    private final VehicleBrandRepository vehicleBrandRepository;

    @Override
    public List<VehicleBrand> getAllVehicleBrands() {
        return vehicleBrandRepository.findAll();
    }

    @Override
    public List<VehicleBrand> addAllVehicleBrands(List<VehicleBrand> vehicleBrands) {
        return vehicleBrandRepository.saveAll(vehicleBrands);
    }

    @Override
    public void removeVehicleBrandById(Long vehicleBrandId) {
        vehicleBrandRepository.deleteById(vehicleBrandId);
    }

}
