package com.innowise.DudeWhereIsMyCar.service.messageBroker;

import com.innowise.DudeWhereIsMyCar.dto.requests.LoginDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "topic", groupId = "group_id")
    public void listenToKafkaTopic(LoginDTO loginDTO) {
        System.out.println("Message received is " + loginDTO);
    }
}
