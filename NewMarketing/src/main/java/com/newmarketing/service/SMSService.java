package com.newmarketing.service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.newmarketing.entity.SMS;
import com.twilio.Twilio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.net.URI;

@Component
public class SMSService {

//    @Value("#{systemEnvironment['ACeda08aff3f10ba9fbb5195bcb6e17da1']}")
//    private String ACCOUNT_SID;
//
//    @Value("#{systemEnvironment['d26ae9d8ee123622400f334c42c19c2b']}")
//    private String AUTH_TOKEN;
//
//    @Value("#{systemEnvironment['+14695072983']}")
//    private String FROM_NUMBER;
    
    public static final String ACCOUNT_SID = "ACeda08aff3f10ba9fbb5195bcb6e17da1";
    public static final String AUTH_TOKEN = "d26ae9d8ee123622400f334c42c19c2b";
    public static final String FROM_NUMBER = "+14695072983";

    public void send(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}
