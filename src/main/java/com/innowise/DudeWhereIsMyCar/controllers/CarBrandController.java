package com.innowise.DudeWhereIsMyCar.controllers;

import com.innowise.DudeWhereIsMyCar.Mappers.CarBrandMapper;
import com.innowise.DudeWhereIsMyCar.dto.CarBrandRequest;
import com.innowise.DudeWhereIsMyCar.dto.CarBrandResponse;
import com.innowise.DudeWhereIsMyCar.entity.CarBrand;
import com.innowise.DudeWhereIsMyCar.service.CarBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CarBrandController {

    private final CarBrandService carBrandService;
    private final CarBrandMapper carBrandMapper;

    @PostMapping("/addCarBrand")
    public ResponseEntity<CarBrandResponse> addCarBrand(@RequestBody CarBrandRequest carBrandRequest) {
        CarBrand savedCarBrand = carBrandService.addBrand(carBrandMapper.toCarBrand(carBrandRequest));
        return new ResponseEntity<>(carBrandMapper.toCarBrandResponse(savedCarBrand), HttpStatus.CREATED);
    }
}
