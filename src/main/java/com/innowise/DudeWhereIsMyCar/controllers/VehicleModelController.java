package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.controllers.validators.ValidList;
import com.innowise.DudeWhereIsMyCar.dto.mapers.VehicleModelMapper;
import com.innowise.DudeWhereIsMyCar.dto.requests.VehicleModelRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.VehicleModelResponse;
import com.innowise.DudeWhereIsMyCar.models.VehicleModel;
import com.innowise.DudeWhereIsMyCar.service.VehicleModelService;
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
@RequestMapping("/vehicleModels")
public class VehicleModelController {

    private final VehicleModelMapper vehicleModelMapper;
    private final VehicleModelService vehicleModelService;

    @PostMapping("/v1")
    public List<VehicleModelResponse> addVehicleModels(@RequestBody @Valid ValidList<VehicleModelRequest> vehicleModelsRequest) {
        List<VehicleModel> vm = vehicleModelMapper.toVehicleModels(vehicleModelsRequest);
        List<VehicleModel> savedVehicleModels = vehicleModelService.addVehicleModels(vm);
        return vehicleModelMapper.toVehicleModelResponses(savedVehicleModels);
    }

    @DeleteMapping("/v1/{modelId}")
    public ResponseEntity<?> removeVehicleModel(@PathVariable Long modelId) {
        vehicleModelService.removeVehicleModelById(modelId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/v1")
    public List<VehicleModelResponse> getVehicleModels() {
        return vehicleModelMapper.toVehicleModelResponses(vehicleModelService.getAllVehicleModels());
    }


}
