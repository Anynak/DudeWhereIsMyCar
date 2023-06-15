package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.exceptions.ResourceNotFoundException;
import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import com.innowise.dude_where_is_my_car.repositories.VehicleBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleBrandService {
    private final VehicleBrandRepository vehicleBrandRepository;


    public VehicleBrand getVehicleBrandById(Long id) {
        return vehicleBrandRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vehicle brand with id " + id + " not found"));
    }


    public List<VehicleBrand> getAllVehicleBrands() {
        return vehicleBrandRepository.findAll();
    }


    public List<VehicleBrand> addAllVehicleBrands(List<VehicleBrand> vehicleBrands) {
        return vehicleBrandRepository.saveAll(vehicleBrands);
    }


    public void removeVehicleBrandById(Long vehicleBrandId) {
        vehicleBrandRepository.deleteById(vehicleBrandId);
    }

}
