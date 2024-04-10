package com.cts.employee.service;

import java.util.List;

import com.cts.employee.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id);

	Boolean deleteEmployee(Long id);

	EmployeeDto getEmployeeById(Long id);
}
