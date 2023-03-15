package com.christinac.studentRoster.services;

import java.util.List;
import java.util.Optional;

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
	
	public Student findById(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();			
		} else {
			return null;
		}
	}
	
	public Student create(Student s) {
		return studentRepo.save(s);
	}
	
	public Student update(Student s) {
		return studentRepo.save(s);
	}
	
	public Student leaveDorm(Student s) {
		s.setDorm(null);
		return studentRepo.save(s);
	}
}
