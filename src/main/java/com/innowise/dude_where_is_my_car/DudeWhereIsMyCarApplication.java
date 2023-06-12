package com.innowise.dude_where_is_my_car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DudeWhereIsMyCarApplication {
    public static void main(String[] args) {
        SpringApplication.run(DudeWhereIsMyCarApplication.class, args);
    }

}
