package com.newmarketing.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newmarketing.entity.DoituongEntity;
import com.newmarketing.entity.KhachangEntity;
import com.newmarketing.service.KhachhangService;

@RestController
public class KhachHangController {

	@Autowired
	KhachhangService service;
	
	@CrossOrigin(value = "*")
	@RequestMapping("/khachhang")
	public List<KhachangEntity> getOne(@RequestParam("madoituong") DoituongEntity madoituong) {
		
		return service.getOne(madoituong);
	}
}
