package com.innowise.DudeWhereIsMyCar.service.impl;

import com.innowise.DudeWhereIsMyCar.models.VehicleModel;
import com.innowise.DudeWhereIsMyCar.repositories.VehicleModelRepository;
import com.innowise.DudeWhereIsMyCar.service.VehicleModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleModelServiceImpl implements VehicleModelService {

    private final VehicleModelRepository vehicleModelRepository;

    @Override
    public List<VehicleModel> getAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public List<VehicleModel> addVehicleModels(List<VehicleModel> vehicleModels) {
        return vehicleModelRepository.saveAll(vehicleModels);
    }

    @Override
    public void removeVehicleModelById(Long vehicleModelId) {
        vehicleModelRepository.deleteById(vehicleModelId);
    }
}
