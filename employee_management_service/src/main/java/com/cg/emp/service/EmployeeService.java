package com.cg.emp.service;

import java.util.List;

import com.cg.emp.dto.EmployeeDto;
import com.cg.emp.entities.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(EmployeeDto employee /*, int empId */);
	
	public Employee getEmployee(int empId);
	
	public List<Employee> getEmployees();
	
	
	public void deleteEmployee(int empId);
	


}
