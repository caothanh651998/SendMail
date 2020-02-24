package com.mail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mail.entity.Contact;
import com.mail.service.MailSerice;

@Controller
@RequestMapping("contact")
public class ContactController {

	@Autowired
	private MailSerice mailSerice;
	
	@RequestMapping( method = RequestMethod.GET)
	public String index( ModelMap modelMap) {
		modelMap.addAttribute("contact", new Contact());
		return "form";
	}
	@RequestMapping( value="send", method = RequestMethod.POST)
	public String send(@ModelAttribute("contact") Contact contact , ModelMap modelMap) {
		
		try {
			String content = "<br> Chủ đề :" + contact.getSubject();
			content += "<br> Nội dung :" +contact.getContent();
			mailSerice.send("caothanh651998@gmail.com",contact.getEmail(), contact.getSubject(), content);
			modelMap.put("msg", "Done!");
		} catch (Exception e) {
			modelMap.put("msg", e.getMessage());
		}
		
		return "form";
	}
}
