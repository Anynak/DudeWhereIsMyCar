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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
public class VehicleBrandController {

    private final VehicleBrandService vehicleBrandService;
    private final VehicleBrandMapper vehicleBrandMapper;

    @PostMapping("/setVehicleBrands")
    public ResponseEntity<List<VehicleBrandResponse>> addVehicleBrands(@RequestBody @Valid Set<VehicleBrandRequest> vehicleBrandsRequest) {
        List<VehicleBrand> savedVehicleBrands = vehicleBrandService.addAllVehicleBrands(vehicleBrandMapper.toVehicleBrands(vehicleBrandsRequest));
        return new ResponseEntity<>(
                vehicleBrandMapper.toVehicleBrandsResponse(savedVehicleBrands),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/deleteVehicleBrand/{brandId}")
    public ResponseEntity<?> removeVehicleBrand(@PathVariable Long brandId) {
        vehicleBrandService.removeVehicleBrandById(brandId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getVehicleBrands")
    public ResponseEntity<List<VehicleBrandResponse>> getVehicleBrands() {
        return new ResponseEntity<>(
                vehicleBrandMapper.toVehicleBrandsResponse(vehicleBrandService.getAllVehicleBrands()),
                HttpStatus.OK
        );
    }
}
