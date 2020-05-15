package com.newmarketing.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.newmarketing.entity.ChiendichEntity;
import com.newmarketing.service.ChiendichService;

@Controller
public class ChiendichController {
	
	@Autowired
	ChiendichService service;
	
	@RequestMapping("marketing")
	public String index(Model model) {
		model.addAttribute("chiendich",new ChiendichEntity());
		return "index";
	}
	
	@RequestMapping("chiendich")
	public String getAll(Model model) {
		model.addAttribute("chiendich", service.getAll()) ;
		return "campaign";
	}
	
	@RequestMapping("marketing/add")
	public String Save(@Valid ChiendichEntity entity) {
		service.Save(entity);
		return "redirect:/chiendich";
	}
	
	@RequestMapping("/marketing/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("chiendich", service.finByid(id));
		return "index";	
	}
	
	@RequestMapping("/marketing/{id}/del")
	public String del(@PathVariable int id ) {
		service.del(id);
		return "redirect:/chiendich";
	}

}
