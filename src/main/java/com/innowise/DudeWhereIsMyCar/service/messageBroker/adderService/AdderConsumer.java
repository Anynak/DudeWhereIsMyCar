package com.innowise.DudeWhereIsMyCar.service.messageBroker.adderService;

import com.innowise.DudeWhereIsMyCar.dto.messageBrocker.SumTask;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//https://medium.com/event-driven-utopia/understanding-kafka-topic-partitions-ae40f80552e8
@Service
@RequiredArgsConstructor
public class AdderConsumer {

    private final AdderProducer adderProducer;

    @KafkaListener(topics = "in", groupId = "adder_1")
    public void listenToKafkaTopic(SumTask sumTask) {
        sumTask.setSum(sumTask.getN1() + sumTask.getN2());
        adderProducer.sendMessageToTopic(sumTask);
    }
}
