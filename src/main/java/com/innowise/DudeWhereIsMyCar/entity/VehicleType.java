package com.innowise.DudeWhereIsMyCar.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehicle_type", schema = "dude_where_is_my_car")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_type_id", nullable = false)
    private Long vehicleTypeId;

    @Column(name = "type_name", nullable = false)
    private String typeName;
}
