package com.innowise.dude_where_is_my_car.service;

import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import com.innowise.dude_where_is_my_car.models.VehicleModel;
import com.innowise.dude_where_is_my_car.repositories.VehicleModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;
    private final VehicleBrandService vehicleBrandService;


    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }


    public List<VehicleModel> addVehicleModels(List<VehicleModel> vehicleModels) {
        return vehicleModelRepository.saveAll(vehicleModels);
    }


    public void removeVehicleModelById(Long vehicleModelId) {
        vehicleModelRepository.deleteById(vehicleModelId);
    }


    public List<VehicleModel> getVehicleModelsByBrand(Long brandId) {
        VehicleBrand vehicleBrand = vehicleBrandService.getVehicleBrandById(brandId);
        return vehicleModelRepository.findAllByVehicleBrand(vehicleBrand);
    }
}
