package com.innowise.DudeWhereIsMyCar.vehicleBrand;

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
