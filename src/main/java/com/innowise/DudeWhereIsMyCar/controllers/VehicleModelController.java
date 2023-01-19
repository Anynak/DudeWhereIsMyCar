package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.VehicleModelMapper;


import com.innowise.DudeWhereIsMyCar.dto.request.VehicleModelRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleModelResponse;

import com.innowise.DudeWhereIsMyCar.entity.VehicleModel;
import com.innowise.DudeWhereIsMyCar.service.VehicleModelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
public class VehicleModelController {

    private final VehicleModelMapper vehicleModelMapper;

    private final VehicleModelService vehicleModelService;

    @PostMapping("/setVehicleModels")
    public ResponseEntity<List<VehicleModelResponse>> addVehicleModels(@RequestBody @Valid List<VehicleModelRequest> vehicleModelsRequest) {
        List<VehicleModel> savedVehicleModels = vehicleModelService.addVehicleModels(vehicleModelMapper.toVehicleModels(vehicleModelsRequest));
        return new ResponseEntity<>(
                vehicleModelMapper.toVehicleModelResponses(savedVehicleModels),
                HttpStatus.CREATED
        );
    }


}
