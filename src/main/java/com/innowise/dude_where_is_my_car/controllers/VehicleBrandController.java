package com.innowise.dude_where_is_my_car.controllers;

import com.innowise.dude_where_is_my_car.controllers.validators.ValidList;
import com.innowise.dude_where_is_my_car.dto.mapers.VehicleBrandMapper;
import com.innowise.dude_where_is_my_car.dto.requests.VehicleBrandRequest;
import com.innowise.dude_where_is_my_car.dto.responses.VehicleBrandResponse;
import com.innowise.dude_where_is_my_car.models.VehicleBrand;
import com.innowise.dude_where_is_my_car.service.VehicleBrandService;
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
@RequestMapping("/vehicleBrands/v1")
public class VehicleBrandController {

    private final VehicleBrandService vehicleBrandService;
    private final VehicleBrandMapper vehicleBrandMapper;

    @PostMapping
    public ResponseEntity<List<VehicleBrandResponse>> addVehicleBrands(@RequestBody @Valid ValidList<VehicleBrandRequest> vehicleBrandsRequest) {
        List<VehicleBrand> savedVehicleBrands = vehicleBrandService.addAllVehicleBrands(vehicleBrandMapper.toVehicleBrands(vehicleBrandsRequest));
        return new ResponseEntity<>(
                vehicleBrandMapper.toVehicleBrandsResponse(savedVehicleBrands),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{brandId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeVehicleBrand(@PathVariable Long brandId) {
        vehicleBrandService.removeVehicleBrandById(brandId);
    }

    @GetMapping
    public List<VehicleBrandResponse> getVehicleBrands() {
        return vehicleBrandMapper.toVehicleBrandsResponse(vehicleBrandService.getAllVehicleBrands());
    }
}
