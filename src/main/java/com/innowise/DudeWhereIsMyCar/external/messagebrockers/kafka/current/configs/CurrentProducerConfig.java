package com.innowise.DudeWhereIsMyCar.external.messagebrockers.kafka.current.configs;

import com.innowise.DudeWhereIsMyCar.external.messagebrockers.dto.SumTask;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CurrentProducerConfig {
    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String brokerServer;

    public ProducerFactory<String, SumTask> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerServer);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean("currentKafkaTemplate")
    public KafkaTemplate<String, SumTask> currentKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
