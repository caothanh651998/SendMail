package com.newmarketing.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newmarketing.entity.TuvanEntity;
import com.newmarketing.service.TuvanService;

@Controller
@RequestMapping("tuvan")
public class TuvanController {

	@Autowired
	TuvanService service;
	
	@RequestMapping("list")
	public String getAll() {
		
		return "";
	}
	
	@RequestMapping("tuvan/save")
	public String Save( TuvanEntity entity) {
		service.save(entity);
		return "redirect:/tuvan";
	}
}
