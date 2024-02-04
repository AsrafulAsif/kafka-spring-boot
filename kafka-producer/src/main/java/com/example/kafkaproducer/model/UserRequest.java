package com.example.kafkaproducer.model;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String age;
    private boolean activeStatus;
}
