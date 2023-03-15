package com.christinac.studentRoster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.christinac.studentRoster.models.Dorm;
import com.christinac.studentRoster.services.DormService;

@Controller
public class HomeController {
	
	@Autowired
	private DormService dormServ;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Dorm> allDorms = dormServ.findAll();
		model.addAttribute("allDorms", allDorms);
		return "index.jsp";
	}
	
	@GetMapping("/dorm/new")
	public String newDorm(@ModelAttribute("newDorm") Dorm newDorm) {
		return "newDorm.jsp";
	}
	
	@GetMapping("/student/new")
	public String newStudent() {
		return "newStudent.jsp";
	}
}
