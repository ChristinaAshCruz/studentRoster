package com.christinac.studentRoster.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.christinac.studentRoster.models.Dorm;
import com.christinac.studentRoster.models.Student;
import com.christinac.studentRoster.services.DormService;
import com.christinac.studentRoster.services.StudentService;

@Controller
@RequestMapping("/dorm")
public class DormController {
	
	@Autowired
	private DormService dormServ;
	@Autowired
	private StudentService studentServ;
	
	
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
	public String viewDormStudents(@PathVariable("id") Long id, @ModelAttribute("newDormStudent") Student newDormStudent, Model model) {
		// use your id with model.addAttribute
		Dorm thisDorm = dormServ.findDormById(id);
		model.addAttribute("thisDorm", thisDorm);
		// set up your new dorm student form
		List<Student> allStudents = studentServ.findAll();
		System.out.println(allStudents);
		model.addAttribute("allStudents", allStudents);
		return "viewDorm.jsp";
	}
	
	@PostMapping("/{dormId}/add-student")
	public String addStudentToDorm(@PathVariable("dormId") Long dormId, @RequestParam("students") Long studentId) {
		// have student leave their current dorm
		Student thisStudent = studentServ.findById(studentId);
		studentServ.leaveDorm(thisStudent);
		// have student now join this dorm
		Dorm dorm = dormServ.findDormById(dormId);
		thisStudent.setDorm(dorm);
		// update that student's attribute/data
		studentServ.update(thisStudent);
		return "redirect:/dorm/" + dormId;
	}
	
	
}
