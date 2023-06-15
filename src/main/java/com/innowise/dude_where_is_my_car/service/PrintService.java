package com.innowise.dude_where_is_my_car.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrintService {


    public void print() {
        log.info("app is working");
    }
}
