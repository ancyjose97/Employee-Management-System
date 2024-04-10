package com.cts.employee.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cts.employee.dto.EmployeeDto;
import com.cts.employee.entity.Employee;
import com.cts.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private ModelMapper modelMapper;

	private EmployeeRepository employeeRepository;

	
	
	public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
		this.modelMapper = modelMapper;
		this.employeeRepository = employeeRepository;
	}



	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		
		Employee newEmployee = employeeRepository.save(employee);
		
		return modelMapper.map(newEmployee, EmployeeDto.class);
		
	}



	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).toList();
	}
	
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
		
		Employee employee =	employeeRepository.findById(id).get();
	
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		
		return modelMapper.map(updatedEmployee, EmployeeDto.class);
	}



	@Override
	public Boolean deleteEmployee(Long id) {
		
		Employee employee =	employeeRepository.findById(id).get();

		employeeRepository.delete(employee);
		
		return true;
	}



	@Override
	public EmployeeDto getEmployeeById(Long id) {
		
		Employee employee = employeeRepository.findById(id).get();
		
		return modelMapper.map(employee, EmployeeDto.class);
	}



	
}
