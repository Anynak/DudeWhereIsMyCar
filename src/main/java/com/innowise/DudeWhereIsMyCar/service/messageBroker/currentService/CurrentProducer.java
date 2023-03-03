package com.innowise.DudeWhereIsMyCar.service.messageBroker.currentService;

import com.innowise.DudeWhereIsMyCar.dto.messageBrocker.SumTask;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentProducer {

    private final KafkaTemplate<String, SumTask> kafkaTemplate;

    public void sendMessageToTopic(SumTask sumTask) {
        kafkaTemplate.send("in", sumTask);
    }
}
