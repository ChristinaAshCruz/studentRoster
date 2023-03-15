package com.christinac.studentRoster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.christinac.studentRoster.models.Dorm;
import com.christinac.studentRoster.models.Student;
import com.christinac.studentRoster.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentServ;
	
	@PostMapping("/create")
	public String createStudent(@Valid @ModelAttribute("newStudent") Student newStudent, BindingResult result) {
		if(result.hasErrors()) {
			return "newStudent.jsp";
		}
		studentServ.create(newStudent);
		Dorm dorm = newStudent.getDorm();
		Long dormId = dorm.getId();
		
		return "redirect:/dorm/" + dormId;
	}
	
	@GetMapping("/{studentId}/delete/{dormId}")
	public String removeStudentFromDorm(@PathVariable("studentId") Long studentId, @PathVariable("dormId") Long dormId) {
		Student thisStudent = studentServ.findById(studentId);
		// have student remove themselves from their current dorm
		studentServ.leaveDorm(thisStudent);
		
		return "redirect:/dorm/" + dormId;
	}
	
}
