package com.christinac.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.christinac.studentRoster.models.Student;

@Service
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	@Override
	public List<Student> findAll();
}
