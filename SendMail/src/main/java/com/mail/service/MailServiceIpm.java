package com.mail.service;

import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceIpm implements MailSerice{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void send(String fromAddress, String toAddress, String subject, String content) throws Exception {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(fromAddress);
		helper.setTo(InternetAddress.parse(toAddress));
		helper.setSubject(subject);
		helper.setText(content, true);
		helper.setSentDate(new Date());
		javaMailSender.send(mimeMessage);
		
	}

}
