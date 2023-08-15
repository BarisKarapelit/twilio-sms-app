package com.example.twilio.sms.controller;

import com.example.twilio.sms.service.Impl.SmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {
    @Autowired
    private  SmsServiceImpl smsService;

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() throws Exception {
        return smsService.send();
    }
}
