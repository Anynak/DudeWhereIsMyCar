package com.innowise.DudeWhereIsMyCar.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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