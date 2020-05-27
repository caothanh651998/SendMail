package com.newmarketing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.newmarketing.entity.Contact;
import com.newmarketing.service.ChiendichService;
import com.newmarketing.service.DoituongService;
import com.newmarketing.service.KhachhangService;
import com.newmarketing.service.MailSerice;

@Controller
@RequestMapping("contact")
public class ContactController {

	@Autowired
	private MailSerice mailSerice;
	
	@Autowired
	KhachhangService service;
	
	@Autowired
	ChiendichService Cdservice;
	
	@Autowired
	DoituongService Khservice;
	
	@RequestMapping( method = RequestMethod.GET)
	public String index( ModelMap modelMap) {
		modelMap.addAttribute("contact", new Contact());
		modelMap.addAttribute("contactt", service.getAll());
		modelMap.addAttribute("chiendich", Cdservice.getAll());
		modelMap.addAttribute("khachhang", Khservice.getAll()) ;
		return "Email";
	}
	@RequestMapping( value="send", method = RequestMethod.POST)
	public String send(@ModelAttribute("contact") Contact contact , ModelMap modelMap, RedirectAttributes redirAttrs) {
		
		try {
			String content = "<br> Chủ đề :" + contact.getSubject();
			content += "<br> Nội dung :" +contact.getContent();
			mailSerice.send("caothanh651998@gmail.com",contact.getEmail(), contact.getSubject(), content);
			String  err= "Mail đã được gửi thành công đến : "+ contact.getEmail();
			redirAttrs.addFlashAttribute("msg",  err );
			System.out.println("Done!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			modelMap.put("msg", e.getMessage());
		}
		
		return "redirect:/contact";
	}
}
