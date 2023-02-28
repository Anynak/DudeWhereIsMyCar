package com.innowise.DudeWhereIsMyCar.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "vehicle_type", schema = "dude_where_is_my_car")
public class VehicleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_type_id", nullable = false)
    private Long vehicleTypeId;

    @Column(name = "type_name", nullable = false, unique = true)
    private String typeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VehicleType that = (VehicleType) o;
        return vehicleTypeId != null && Objects.equals(vehicleTypeId, that.vehicleTypeId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
