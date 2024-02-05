package com.example.kafkaconsumer.service;



import com.example.kafkaconsumer.model.EventRequest;
import com.example.kafkaconsumer.model.UserRequest;
import com.example.kafkaconsumer.util.ConvertingObjectStringObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;
    @KafkaListener(topics = {"event-topic-message"}, groupId = "eventStringId")
    public void consumeString(String message) {
        log.info("**** -> Consumed message -> {}", message);
    }

    @KafkaListener(topics = {"event-topic-json"}, groupId = "eventRequestId",containerFactory = "kafkaListenerContainerJsonFactory")
    public void consumeEventRequestJson(ConsumerRecord<String,Object> record) {
        System.out.println(record.value().getClass().getSimpleName());
        EventRequest pojo = objectMapper.convertValue(record.value(), EventRequest.class);
        System.out.println(pojo.getMessage());
        log.info("**** -> Consumed json -> {}", record.value().toString());
    }

    @KafkaListener(topics = {"data-topic"}, groupId = "dataId")
    public void consumeData(String data) {
        EventRequest eventRequest = ConvertingObjectStringObject.convertStringToObject(data,EventRequest.class);
        log.info("**** -> Consumed data -> {}", eventRequest.getMessage());
        log.info("**** -> Consumed data -> {}", eventRequest.getCode());
    }

    @KafkaListener(topics = {"user-topic"}, groupId = "dataId")
    public void consumeUserData(String data) {
        log.info("**** -> Consumed Data {}",data);
        UserRequest userRequest = ConvertingObjectStringObject.convertStringToObject(data,UserRequest.class);
        log.info("**** -> Consumed user name -> {}", userRequest.getUserName());
    }
}
