package com.innowise.dude_where_is_my_car.service.impl;

import com.innowise.dude_where_is_my_car.service.PrintService;
import org.springframework.stereotype.Service;

@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public void print() {
        System.out.println("app is working");
    }
}
