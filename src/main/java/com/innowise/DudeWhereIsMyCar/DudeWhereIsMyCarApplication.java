package com.innowise.DudeWhereIsMyCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//https://exchangerate.host/#/#docs
@SpringBootApplication
@EnableFeignClients
public class DudeWhereIsMyCarApplication {
    public static void main(String[] args) {
        SpringApplication.run(DudeWhereIsMyCarApplication.class, args);
    }

}
