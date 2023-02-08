package com.innowise.DudeWhereIsMyCar.service;

import com.innowise.DudeWhereIsMyCar.model.VehicleType;
import com.innowise.DudeWhereIsMyCar.repositories.VehicleTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleTypeServiceImpl implements VehicleTypeService {
    private final VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<VehicleType> saveAll(List<VehicleType> vehicleTypes) {
        return vehicleTypeRepository.saveAll(vehicleTypes);
    }

    @Override
    public void deleteVehicleType(Long typeId) {
        vehicleTypeRepository.deleteById(typeId);
    }

    @Override
    public List<VehicleType> getAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }
}
