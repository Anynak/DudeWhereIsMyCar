package com.innowise.dude_where_is_my_car.controllers;

import com.innowise.dude_where_is_my_car.external.message_brockers.SumTaskDto;
import com.innowise.dude_where_is_my_car.external.message_brockers.kafka.current.CurrentProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/sum")
public class JustForKafkaController {
    private final CurrentProducerService currentProducer;

    @PostMapping("/{n1}/{n2}")
    @ResponseStatus(HttpStatus.OK)
    public void registerUser(@PathVariable Long n1, @PathVariable Long n2) {
        SumTaskDto sumTask = new SumTaskDto(n1, n2);
        currentProducer.sendMessageToTopic(sumTask);
    }
}
