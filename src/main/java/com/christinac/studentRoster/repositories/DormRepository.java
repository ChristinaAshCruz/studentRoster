package com.christinac.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.christinac.studentRoster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long>{
	
	@Override
	public List<Dorm> findAll();
}
