package com.christinac.studentRoster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinac.studentRoster.models.Student;
import com.christinac.studentRoster.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> findAll(){
		return studentRepo.findAll();
	}
	
}
