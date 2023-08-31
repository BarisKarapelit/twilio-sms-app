package com.example.twilio.sms.service;

import com.example.twilio.sms.model.SmsRequest;
import org.springframework.http.ResponseEntity;

public interface SmsService {
    ResponseEntity<String> send(SmsRequest smsRequest) throws Exception;
}
