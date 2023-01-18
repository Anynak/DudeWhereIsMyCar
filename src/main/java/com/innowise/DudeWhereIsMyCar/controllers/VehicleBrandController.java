package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.VehicleBrandMapper;
import com.innowise.DudeWhereIsMyCar.dto.request.VehicleBrandRequest;
import com.innowise.DudeWhereIsMyCar.dto.response.VehicleBrandResponse;
import com.innowise.DudeWhereIsMyCar.entity.VehicleBrand;
import com.innowise.DudeWhereIsMyCar.service.VehicleBrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
public class VehicleBrandController {

    private final VehicleBrandService vehicleBrandService;
    private final VehicleBrandMapper vehicleBrandMapper;

    @PostMapping("/addVehicleBrand")
    public ResponseEntity<VehicleBrandResponse> addCarBrand(@RequestBody @Valid VehicleBrandRequest vehicleBrandRequest) {
        VehicleBrand savedVehicleBrand = vehicleBrandService.addBrand(vehicleBrandMapper.toVehicleBrand(vehicleBrandRequest));
        return new ResponseEntity<>(
                vehicleBrandMapper.toVehicleBrandResponse(savedVehicleBrand),
                HttpStatus.CREATED
        );
    }
}
