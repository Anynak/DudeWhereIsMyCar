package com.innowise.dude_where_is_my_car.service.impl;

import com.innowise.dude_where_is_my_car.service.PrintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrintServiceImpl implements PrintService {

    @Override
    public void print() {
        log.info("app is working");
    }
}
