package com.innowise.dude_where_is_my_car.service.impl;

import com.innowise.dude_where_is_my_car.exceptions.ResourceNotFoundException;
import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import com.innowise.dude_where_is_my_car.repositories.VehicleBrandRepository;
import com.innowise.dude_where_is_my_car.service.VehicleBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleBrandServiceImpl implements VehicleBrandService {
    private final VehicleBrandRepository vehicleBrandRepository;

    @Override
    public VehicleBrand getVehicleBrandById(Long id) {
        return vehicleBrandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle brand with id " + id + " not found"));
    }

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
