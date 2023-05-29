package com.innowise.dude_where_is_my_car.external.message_brockers.kafka.current.configs;

import com.innowise.dude_where_is_my_car.external.message_brockers.dto.SumTask;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class CurrentConsumerConfig {
    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String brokerServer;

    public ConsumerFactory<String, SumTask> consumerFactory() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerServer);
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configMap.put(JsonDeserializer.VALUE_DEFAULT_TYPE, SumTask.class);
        return new DefaultKafkaConsumerFactory<>(configMap);
    }

    @Bean("currentKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, SumTask>
    currentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, SumTask> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
