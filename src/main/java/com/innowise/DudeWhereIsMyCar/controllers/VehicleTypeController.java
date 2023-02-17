package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.DTO.mapers.VehicleTypeMapper;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.VehicleTypeRequest;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.VehicleTypeResponse;
import com.innowise.DudeWhereIsMyCar.model.VehicleType;
import com.innowise.DudeWhereIsMyCar.service.VehicleTypeService;
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
@RequestMapping("/vehicleTypes")
public class VehicleTypeController {
    private final VehicleTypeMapper vehicleTypeMapper;
    private final VehicleTypeService vehicleTypeService;

    @PostMapping("/v1")
    public ResponseEntity<List<VehicleTypeResponse>> addVehicleTypes(
            @RequestBody @Valid ValidList<VehicleTypeRequest> vehicleTypeRequests) {
        List<VehicleType> vehicleTypes = vehicleTypeService.saveAll(vehicleTypeMapper.toVehicleTypes(vehicleTypeRequests));
        List<VehicleTypeResponse> vehicleTypeResponses = vehicleTypeMapper.toVehicleTypeResponses(vehicleTypes);
        return new ResponseEntity<>(vehicleTypeResponses, HttpStatus.CREATED);
    }

    @DeleteMapping("v1/{typeId}")
    public ResponseEntity<?> deleteVehicleType(@PathVariable Long typeId) {
        vehicleTypeService.deleteVehicleType(typeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/v1")
    public List<VehicleTypeResponse> getVehicleTypes() {
        return vehicleTypeMapper.toVehicleTypeResponses(vehicleTypeService.getAllVehicleTypes());
    }
}
