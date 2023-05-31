package com.innowise.dude_where_is_my_car.external.message_brockers.kafka.adder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdderProducerService {

    @Autowired
    @Qualifier("adderKafkaTemplate")
    private KafkaTemplate<String, Long> kafkaTemplate;

    public void sendMessageToTopic(Long sum) {
        kafkaTemplate.send("out", sum);
    }
}
