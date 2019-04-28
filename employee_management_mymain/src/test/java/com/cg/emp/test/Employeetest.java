package com.cg.emp.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.emp.dto.EmployeeDto;
import com.cg.emp.entities.Department;
import com.cg.emp.entities.Employee;
import com.cg.emp.entities.GradeMaster;
import com.cg.emp.repository.DepartmentRepository;
import com.cg.emp.repository.EmployeeRepository;
import com.cg.emp.repository.GradeMasterRepository;
import com.cg.emp.service.DepartmentServiceImpl;
import com.cg.emp.service.EmployeeServiceImpl;
import com.cg.emp.service.GradeMasterServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class Employeetest {

	@Mock
	DepartmentRepository deptRepo;

	@InjectMocks
	private DepartmentServiceImpl deptService;

	@Test
	public void addDepartment() throws Exception {

		Department dept = new Department();
		dept.setDeptId(101);
		dept.setDeptName("CSE");

		when(deptRepo.save(Mockito.any(Department.class))).thenReturn(dept);
		Department expect = deptService.addDepartment(dept);
		assertEquals(expect, dept);
	}

	@Mock
	GradeMasterRepository gradeRepo;

	@InjectMocks
	private GradeMasterServiceImpl gradeService;

	@Test
	public void addGradeMaster() throws Exception {

		GradeMaster grade = new GradeMaster();
		grade.setGradeCode("M1");
		grade.setDescription("EmployeeGrade");
		grade.setMinSal(10000);
		grade.setMaxSal(100000);
		when(gradeRepo.save(grade)).thenReturn(grade);
		GradeMaster expects = gradeService.addGradeMaster(grade);
		assertEquals(expects, grade);

	}

	@Mock
	EmployeeRepository empRepo;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	public void addEmployeeDetails() {
		EmployeeDto empl = new EmployeeDto();
		
		empl.setEmpId(100001);
		empl.setfName("Sanvika");
		empl.setlName("Attili");
		empl.setGender("female");
		empl.setAddress("hyderabad");
		empl.setMaritalStatus("unmaried");
		empl.setMobileNumber(972436243);
		empl.setDesignation("Associate");	
		empl.setGradeMaster("M1");
		empl.setDepartment(101);
		
		Employee employee = new Employee();
		employee.setfName(empl.getfName());
		employee.setlName(empl.getlName());
		employee.setDateOfbirth(empl.getDateOfbirth());
		employee.setDateOfjoining(empl.getDateOfjoining());
		employee.setDesignation(empl.getDesignation());
		employee.setGender(empl.getGender());
		employee.setMaritalStatus(empl.getMaritalStatus());
		employee.setAddress(empl.getAddress());
		employee.setMobileNumber(empl.getMobileNumber());			
		employee.setDepartment(deptRepo.getOne(empl.getDepartment()));
		employee.setGradeMaster(gradeRepo.getOne(empl.getGradeMaster()));
		when(empRepo.save(Mockito.any(Employee.class))).thenReturn(employee);
		Employee expected = employeeService.addEmployee(empl);
		assertEquals(employee, expected);
	}
	
	@Test
	public void updateEmployeeDetails() {
		
	EmployeeDto empl = new EmployeeDto();
		
		empl.setEmpId(100001);
		empl.setfName("Sanvika");
		empl.setlName("Attili");
		empl.setDesignation("Associate");	
				
		Employee employee = new Employee();
		employee.setfName(empl.getfName());
		employee.setlName(empl.getlName());
		
		employee.setDesignation(empl.getDesignation());
		when(empRepo.getOne(100001)).thenReturn(employee);
		Employee expected = employeeService.updateEmployee(employee,employee.getEmpId() );
		assertEquals(employee, expected);
		
		
	}
	
	
	
	public void getEmployeeDetails() {
	EmployeeDto empl = new EmployeeDto();
		
		empl.setEmpId(100001);
		empl.setfName("Sanvika");
		empl.setlName("Attili");
		empl.setGender("female");
		empl.setAddress("hyderabad");
		empl.setMaritalStatus("unmaried");
		empl.setMobileNumber(972436243);
		empl.setDesignation("Associate");	
		empl.setGradeMaster("M1");
		empl.setDepartment(101);
		
		Employee employee = new Employee();
		employee.setfName(empl.getfName());
		employee.setlName(empl.getlName());
		employee.setDateOfbirth(empl.getDateOfbirth());
		employee.setDateOfjoining(empl.getDateOfjoining());
		employee.setDesignation(empl.getDesignation());
		employee.setGender(empl.getGender());
		employee.setMaritalStatus(empl.getMaritalStatus());
		employee.setAddress(empl.getAddress());
		employee.setMobileNumber(empl.getMobileNumber());			
		employee.setDepartment(deptRepo.getOne(empl.getDepartment()));
		employee.setGradeMaster(gradeRepo.getOne(empl.getGradeMaster()));
		when(empRepo.getOne(100001)).thenReturn(employee);
		Employee expected = employeeService.getEmployee(employee.getEmpId());//getEmployees();
		assertEquals(expected, employee);


	}

}
