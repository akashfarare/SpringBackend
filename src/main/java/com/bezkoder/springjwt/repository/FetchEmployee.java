package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Employee;
import com.bezkoder.springjwt.models.User;

@Repository
public interface FetchEmployee extends CrudRepository<Employee, Long>{

 	@Override
	List<Employee> findAll();

	void deleteById(Long id);
 	
}
