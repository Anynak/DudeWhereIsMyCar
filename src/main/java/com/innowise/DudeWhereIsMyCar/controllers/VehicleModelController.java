package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.DTO.mapers.VehicleModelMapper;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.VehicleModelRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.VehicleModelResponse;
import com.innowise.DudeWhereIsMyCar.model.VehicleModel;
import com.innowise.DudeWhereIsMyCar.service.VehicleModelService;
import com.innowise.DudeWhereIsMyCar.validators.ValidList;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
public class VehicleModelController {

    private final VehicleModelMapper vehicleModelMapper;
    private final VehicleModelService vehicleModelService;

    @PostMapping("/vehicleModel")
    public List<VehicleModelResponse> addVehicleModels(@RequestBody @Valid ValidList<VehicleModelRequest> vehicleModelsRequest) {
        List<VehicleModel> vm = vehicleModelMapper.toVehicleModels(vehicleModelsRequest);
        List<VehicleModel> savedVehicleModels = vehicleModelService.addVehicleModels(vm);
        return vehicleModelMapper.toVehicleModelResponses(savedVehicleModels);
    }

    @DeleteMapping("/vehicleModel/{modelId}")
    public ResponseEntity<?> removeVehicleModel(@PathVariable Long modelId) {
        vehicleModelService.removeVehicleModelById(modelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/vehicleModel")
    public List<VehicleModelResponse> getVehicleModels() {
        return vehicleModelMapper.toVehicleModelResponses(vehicleModelService.getAllVehicleModels());
    }


}
