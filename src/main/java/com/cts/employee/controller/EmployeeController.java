package com.cts.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employee.dto.EmployeeDto;
import com.cts.employee.service.EmployeeService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
		
		return new ResponseEntity<>(employeeService.addEmployee(employeeDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long id) {
		
		return new ResponseEntity<>(employeeService.updateEmployee(employeeDto, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		
		Boolean isDeleted = false;
		
		isDeleted = employeeService.deleteEmployee(id);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Deleted", isDeleted);
		
		return ResponseEntity.ok(response);
		
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		
		return new ResponseEntity<> (employeeService.getEmployeeById(id), HttpStatus.OK);
	}
}
