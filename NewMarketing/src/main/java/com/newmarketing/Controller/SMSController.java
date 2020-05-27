package com.newmarketing.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newmarketing.entity.SMS;
import com.newmarketing.service.ChiendichService;
import com.newmarketing.service.SMSService;
import com.twilio.exception.ApiException;

@Controller
//@RequestMapping("SendSms")
//@RestController
public class SMSController {


	@Autowired
    SMSService service;
	
	@Autowired
	ChiendichService Cdservice;

    @Autowired
    private SimpMessagingTemplate webSocket;

    private final String  TOPIC_DESTINATION = "/topic/sms";

	@RequestMapping(value="SendSms", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("chiendich", Cdservice.getAll());
		return "SMS";
	}
	
    
    @RequestMapping(value = "/sms", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsSubmit(@RequestBody SMS sms) {
        try{
            service.send(sms);
        }
        catch(ApiException e){

            webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": lỗi gửi SMS: "+e.getMessage());
            throw e;
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS đã được gửi đến!: "+sms.getTo());

    }

    @RequestMapping(value = "/smscallback", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
       service.receive(map);
       webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Twilio đã thực hiện một yêu cầu gọi lại! Dưới đây là nội dung: "+map.toString());
    }

    private String getTimeStamp() {
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}
