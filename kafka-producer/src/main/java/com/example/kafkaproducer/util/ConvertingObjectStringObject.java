package com.example.kafkaproducer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertingObjectStringObject {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String  convertObjectToString(Object object) {

        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T  convertStringToObject(String data,Class<T> classType) {
        try {
            return objectMapper.readValue(data, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
