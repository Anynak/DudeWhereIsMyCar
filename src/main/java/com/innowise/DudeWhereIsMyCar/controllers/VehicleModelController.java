package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.VehicleModelMapper;

import com.innowise.DudeWhereIsMyCar.dto.request.VehicleModelRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleModelResponse;

import com.innowise.DudeWhereIsMyCar.entity.VehicleModel;
import com.innowise.DudeWhereIsMyCar.service.VehicleModelService;
import com.innowise.DudeWhereIsMyCar.validators.ValidList;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
public class VehicleModelController {

    private final VehicleModelMapper vehicleModelMapper;
    private final VehicleModelService vehicleModelService;

    @PostMapping("/setVehicleModels")
    public ResponseEntity<List<VehicleModelResponse>> addVehicleModels(@RequestBody @Valid ValidList<VehicleModelRequest> vehicleModelsRequest) {
        List<VehicleModel> vm = vehicleModelMapper.toVehicleModels(vehicleModelsRequest);
        List<VehicleModel> savedVehicleModels = vehicleModelService.addVehicleModels(vm);
        return new ResponseEntity<>(
                vehicleModelMapper.toVehicleModelResponses(savedVehicleModels),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/deleteVehicleModel/{modelId}")
    public ResponseEntity<?> removeVehicleModel(@PathVariable Long modelId) {
        vehicleModelService.removeVehicleModelById(modelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getVehicleModels")
    public ResponseEntity<List<VehicleModelResponse>> getVehicleModels() {
        return new ResponseEntity<>(vehicleModelMapper.toVehicleModelResponses(vehicleModelService.getAllVehicleModels()), HttpStatus.OK);
    }


}
