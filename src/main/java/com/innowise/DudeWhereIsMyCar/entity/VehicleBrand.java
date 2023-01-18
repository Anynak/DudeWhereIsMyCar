package com.innowise.DudeWhereIsMyCar.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehicle_brand", schema = "dude_where_is_my_car")
public class VehicleBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_brand_id", nullable = false)
    private Long vehicleBrandId;

    @Column(name = "vehicle_brand_name", nullable = false, unique = true)
    private String vehicleBrandName;

}
