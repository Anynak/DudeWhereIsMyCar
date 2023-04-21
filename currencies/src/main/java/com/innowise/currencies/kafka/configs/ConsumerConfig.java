//package com.innowise.currencies.kafka.configs;
//
//import com.innowise.currencies.dto.CurrencyRateRequest;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableKafka
//@Configuration
//public class ConsumerConfig {
//    @Value("${spring.kafka.consumer.bootstrap-servers}")
//    private String brokerServer;
//
//    public ConsumerFactory<String, CurrencyRateRequest> consumerFactory() {
//        Map<String, Object> configMap = new HashMap<>();
//        configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerServer);
//        configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "group_id");
//        configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configMap.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        configMap.put(JsonDeserializer.VALUE_DEFAULT_TYPE, CurrencyRateRequest.class);
//        return new DefaultKafkaConsumerFactory<>(configMap);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, CurrencyRateRequest>
//    currentKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, CurrencyRateRequest> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//}
