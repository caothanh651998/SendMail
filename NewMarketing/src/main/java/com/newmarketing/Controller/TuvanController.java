package com.newmarketing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.newmarketing.entity.KhachangEntity;
import com.newmarketing.entity.TuvanEntity;
import com.newmarketing.service.KhachhangService;
import com.newmarketing.service.TuvanService;

@Controller
public class TuvanController {

	@Autowired
	TuvanService service;
	
	@Autowired
	KhachhangService khachhang;
	
	@RequestMapping("tuvan")
	public String display( Model model) {
		model.addAttribute("tuvan",new KhachangEntity());
		return "formlh";
	}
	
	@RequestMapping("view")
	public String getAll(Model model) {
//		model.addAttribute("tuvan",new KhachangEntity());
		model.addAttribute("tuvan1", service.getAll());
		return "calendar";
	}
	
	@RequestMapping("save")
	public String Save( TuvanEntity entity , KhachangEntity khEntity) {
		service.save(entity);
		khachhang.saveAll(khEntity);
		return "redirect:/tuvan";
	}
	
	@RequestMapping("tuvan/{matuvan}/remove")
	public String remo(@PathVariable int matuvan){
		service.remove(matuvan);
		return "redirect:/view";
	}
}
