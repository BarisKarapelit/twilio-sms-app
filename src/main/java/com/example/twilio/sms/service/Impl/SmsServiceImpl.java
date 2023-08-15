package com.example.twilio.sms.service.Impl;

import com.example.twilio.sms.contants.TwilioContant;
import com.example.twilio.sms.service.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@Service
public class SmsServiceImpl implements SmsService {


    public static final String USERNAME = System.getenv(TwilioContant.accountSID);
    public static final String AUTH_TOKEN = System.getenv(TwilioContant.authToken);

    @Override
    public ResponseEntity<String> send() throws Exception {
        try {
            Twilio.init(USERNAME, AUTH_TOKEN);

            Message.creator(new PhoneNumber(TwilioContant.phoneNumber),
                    new PhoneNumber(TwilioContant.phoneNumber), "Hello from Twilio 📞").create();
            return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error sending message {} ", e.getMessage().toString());
            e.printStackTrace();
            return new ResponseEntity<String>("Message sent Error " + e.getMessage(), HttpStatus.UNAUTHORIZED);

        }

    }
}
