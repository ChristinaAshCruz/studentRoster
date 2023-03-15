package com.christinac.studentRoster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.christinac.studentRoster.models.Dorm;
import com.christinac.studentRoster.repositories.DormRepository;

@Service
public class DormService {
	
	@Autowired
	private DormRepository dormRepo;
	
	public List<Dorm> findAll(){
		return dormRepo.findAll();
	}
	
	//create a new dorm
	public Dorm createDorm(Dorm d) {
		return dormRepo.save(d);
	}
		
	// find Dorm by id
	public Dorm findDormById(Long id) {
		Optional<Dorm> optionalDorm = dormRepo.findById(id);
		if(optionalDorm.isPresent()) {
			return optionalDorm.get();
		} else {
			return null;
		}
	}
}
