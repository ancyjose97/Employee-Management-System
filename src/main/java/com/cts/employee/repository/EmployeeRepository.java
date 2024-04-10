package com.cts.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
