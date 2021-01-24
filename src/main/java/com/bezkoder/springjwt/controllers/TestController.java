package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.models.Employee;
import com.bezkoder.springjwt.repository.FetchEmployee;
import com.bezkoder.springjwt.security.services.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	FetchEmployee fetchemp;
	
	@Autowired
	UserDetailsServiceImpl userservice;
	
	@GetMapping("/all")
	List<Employee> getEmployee() {
		return fetchemp.findAll();
	}
	
//	@DeleteMapping("/all/{id}")
//	public String deleteEmp(@PathVariable int id)
//	{
//		A e=fetchemp.getOne(id);
//		fetchemp.delete(e);
//		return "deleted";
//			
//	}
	
	@DeleteMapping("/all/{id}")  
	public void deleteBook(@PathVariable("id") Long id)   
	{  
		userservice.delete(id);  
	}  
	
	@PostMapping("/add")
	public Employee createEmployee(@RequestBody Employee employee) {
		return fetchemp.save(employee);
	}
	
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Employee> getEmployeebyid(@PathVariable Long id) throws Exception {
		Employee employee=fetchemp.findById(id).
				orElseThrow(()->new Exception("Employee not exsst with this id"+id));
		return ResponseEntity.ok(employee);
		
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee e) throws Exception {
		Employee employee=fetchemp.findById(id).
				orElseThrow(()->new Exception("Employee not exsst with this id"+id));
		
		employee.setEmpid(e.getEmpid());
		employee.setUsername(e.getUsername());
	
		Employee updated= fetchemp.save(employee);
		return ResponseEntity.ok(updated);
	}
	
}
