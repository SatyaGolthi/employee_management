package com.cg.emp.service;

import java.util.List;

import com.cg.emp.dto.EmployeeDto;
import com.cg.emp.entities.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(EmployeeDto employee );
	
	public Employee getEmployee(int empId);
	
	public List<Employee> getEmployees();
		
	public List<Employee> getEmployeeByName(String fName);
	
	public Employee getEmployeeDetails(String designation,String gradeMaster,int department);
	
	public void deleteEmployee(int empId);
	
	public Employee updateEmployee(Employee employee, int empId);

}
