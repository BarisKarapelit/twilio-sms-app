package com.example.twilio.sms.service;

import org.springframework.http.ResponseEntity;

public interface SmsService {
    ResponseEntity<String> send() throws Exception;
}
