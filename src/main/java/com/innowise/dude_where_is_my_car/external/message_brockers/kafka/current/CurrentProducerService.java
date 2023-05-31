package com.innowise.dude_where_is_my_car.external.message_brockers.kafka.current;

import com.innowise.dude_where_is_my_car.external.message_brockers.SumTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CurrentProducerService {
    @Autowired
    @Qualifier("currentKafkaTemplate")
    private KafkaTemplate<String, SumTaskDto> kafkaTemplate;

    public void sendMessageToTopic(SumTaskDto sumTask) {
        kafkaTemplate.send("in", sumTask);
    }
}
