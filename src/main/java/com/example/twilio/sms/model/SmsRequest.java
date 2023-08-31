package com.example.twilio.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmsRequest {
    String phoneNumber;
    String message;


}
