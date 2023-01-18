package com.innowise.DudeWhereIsMyCar.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "users", schema = "dude_where_is_my_car")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "is_deleted", nullable = false)
    @ColumnDefault("false")
    private Boolean isDeleted;

}
