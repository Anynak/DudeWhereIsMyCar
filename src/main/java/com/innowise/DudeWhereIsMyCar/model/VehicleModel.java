package com.innowise.DudeWhereIsMyCar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//todo Make Composite Key
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "vehicle_model", schema = "dude_where_is_my_car")
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_model_id", nullable = false)
    private Long vehicleModelId;

    @Column(name = "vehicle_model_name", nullable = false)
    private String vehicleModelName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private VehicleBrand vehicleBrand;
}