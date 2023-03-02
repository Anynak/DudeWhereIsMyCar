package com.innowise.DudeWhereIsMyCar.service.messageBroker;

import com.innowise.DudeWhereIsMyCar.dto.requests.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, LoginDTO> kafkaTemplate;

    public void sendMessageToTopic(LoginDTO loginDTO) {
        kafkaTemplate.send("topic", loginDTO);
    }
}
