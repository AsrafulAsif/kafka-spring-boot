package com.example.kafkaconsumer.service;



import com.example.kafkaconsumer.model.EventRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {
    @KafkaListener(topics = {"event-topic-message"}, groupId = "eventStringId")
    public void consumeString(String message) {
        log.info("**** -> Consumed message -> {}", message);
    }

    @KafkaListener(topics = {"event-topic-json"}, groupId = "eventRequestId",containerFactory = "kafkaListenerContainerJsonFactory")
    public void consumeEventRequestJson(EventRequest eventRequest) {
        log.info("**** -> Consumed json -> {}", eventRequest.toString());
    }
}
