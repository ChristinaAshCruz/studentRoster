package com.christinac.studentRoster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.christinac.studentRoster.models.Dorm;
import com.christinac.studentRoster.services.DormService;

@Controller
@RequestMapping("/dorm")
public class DormController {
	
	@Autowired
	private DormService dormServ;
	
	
	@PostMapping("/create")
	public String createDorm(@Valid @ModelAttribute("newDorm") Dorm newDorm, BindingResult result) {
		if(result.hasErrors()) {
			return "newDorm.jsp";
		} else {
			dormServ.createDorm(newDorm);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/{id}")
	public String viewDormStudents(@PathVariable("id") Long id, Model model) {
		Dorm thisDorm = dormServ.findDormById(id);
		model.addAttribute("thisDorm", thisDorm);
		return "viewDorm.jsp";
	}
}
