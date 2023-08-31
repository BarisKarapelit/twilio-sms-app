package com.example.twilio.sms.service.Impl;

import com.example.twilio.sms.contants.TwilioContant;
import com.example.twilio.sms.model.SmsRequest;
import com.example.twilio.sms.service.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public ResponseEntity<String> send(SmsRequest smsRequest) throws Exception {
        try {
//          Twilio.init(TwilioContant.accountSID, TwilioContant.authToken);
            Twilio.init("AC6b4e9fa27cbf417ee4dd2b12305a6f7d", "65b62ddaf4c0b99501bfcd6d879c6304");
            Message message = Message.creator(new PhoneNumber(smsRequest.getPhoneNumber()),
                    new PhoneNumber("+17069488282"),
                    smsRequest.getMessage()).create();
            log.info("Message sent successfully {} ", message.getStatus());
            return new ResponseEntity<String>("Message sent successfully " + message.getStatus(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error sending message {} ", e.getMessage().toString());
            return new ResponseEntity<String>("Message sent Error " + e.getMessage(), HttpStatus.UNAUTHORIZED);

        }

    }
}
