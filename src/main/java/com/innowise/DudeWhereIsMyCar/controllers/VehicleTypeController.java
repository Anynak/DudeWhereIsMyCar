package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.controllers.validators.ValidList;
import com.innowise.DudeWhereIsMyCar.dto.mapers.VehicleTypeMapper;
import com.innowise.DudeWhereIsMyCar.dto.requests.VehicleTypeRequest;
import com.innowise.DudeWhereIsMyCar.dto.responses.VehicleTypeResponse;
import com.innowise.DudeWhereIsMyCar.models.VehicleType;
import com.innowise.DudeWhereIsMyCar.service.VehicleTypeService;
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
