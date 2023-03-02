package com.innowise.DudeWhereIsMyCar.configs.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper;
    private final Class<T> toClass;


    public JsonDeserializer(Class<T> toClass) {
        this.objectMapper = new ObjectMapper();
        this.toClass = toClass;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            return this.objectMapper.readValue(data, toClass);
        } catch (IOException e) {
            throw new SerializationException("Error deserializing with Jackson", e);
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
