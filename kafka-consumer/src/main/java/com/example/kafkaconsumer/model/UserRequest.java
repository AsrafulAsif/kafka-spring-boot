package com.example.kafkaconsumer.model;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String age;
    private boolean activeStatus;
}
