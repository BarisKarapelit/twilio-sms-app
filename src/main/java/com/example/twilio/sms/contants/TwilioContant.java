package com.example.twilio.sms.contants;

import org.springframework.beans.factory.annotation.Value;

public class TwilioContant {
    @Value("${twilio.phoneNumber}")
    public static String phoneNumber;
    @Value("${twilio.accountSID}")
    public static String accountSID;
    @Value("${twilio.authToken}")
    public static String authToken;

}
