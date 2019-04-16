package com.cg.emp.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.cg.emp.dto.EmployeeDto;
import com.cg.emp.entities.Department;
import com.cg.emp.entities.Employee;
import com.cg.emp.repository.DepartmentRepository;
import com.cg.emp.repository.EmployeeRepository;
import com.cg.emp.service.DepartmentServiceImpl;
import com.cg.emp.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class Employeetest {
	
	@Mock
	EmployeeRepository employRepo;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Test
	public void getEmployee() {
		EmployeeDto emp = new EmployeeDto();
		
		emp.setEmpId(100001);
		emp.setFName("Sanvika");
		emp.setLName("Golthi");
		emp.setGender("female");
		emp.setAddress("hyderabad");
		emp.setDepartment(101);
		emp.setGradeMaster("M1");
		emp.setMaritalStatus("unmaried");
		emp.setMobileNumber(972436243);		
	//	when(employRepo.findById(100001)).thenReturn(emp);
}
	
	public void getEmployees() {
		
		List<Employee> employees= Arrays.asList();
		when(employRepo.findAll()).thenReturn(employees);
		List<Employee> expEmployees=employeeService.getEmployees();
		assertEquals(employees,expEmployees);
	} 
//comments
	@Mock
	DepartmentRepository deptRepo;
	
	@InjectMocks
	private DepartmentServiceImpl deptService;
	
public void getDepartments() {
		
		List<Department> departments =Arrays.asList();
		when(deptRepo.findAll()).thenReturn(departments);
		List<Department> expDepartments=deptService.getDepartments();
		assertEquals(departments,expDepartments);
	} 
}
