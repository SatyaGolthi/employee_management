package com.cg.emp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.emp.dto.EmployeeDto;
import com.cg.emp.entities.Department;
import com.cg.emp.entities.Employee;
import com.cg.emp.entities.GradeMaster;
import com.cg.emp.service.DepartmentService;
import com.cg.emp.service.EmployeeService;
import com.cg.emp.service.GradeMasterService;


@RestController
public class EmployeeController {


	@Autowired
	EmployeeService employeeService;

	@Autowired
	GradeMasterService  grademasterService;

	@Autowired
	DepartmentService departmentService;

	//............................... add department .....................................

	@RequestMapping(value="/department", method = RequestMethod.POST)
	public Department addDepartment(@RequestBody Department department) {

		return departmentService.addDepartment(department);
	}
//comments
	
	//............................... add GradeMaster .....................................

	@RequestMapping(value="/grademaster", method = RequestMethod.POST)
	public GradeMaster addGradeMaster( @RequestBody GradeMaster grademaster) {
		System.out.println(grademaster.toString());
		return grademasterService.addGradeMaster(grademaster);
	}

	//............................... add Employee .....................................

	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody EmployeeDto employee) {

		
		return employeeService.addEmployee(employee/*,empId*/);
	}

	
	//............................... get EmployeeDetails by id.....................................
   @RequestMapping(value="/employee/{empId}",method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable int empId)
   {
	return employeeService.getEmployee(empId);
	   
   }
   
 //............................... get AllEmployees   ....................................
   
   @RequestMapping(value="/employees",method=RequestMethod.GET)
   public List<Employee> getEmployees(){
	   
	   return employeeService.getEmployees();
	   

}
   
//............................... delete Employee by Id   ....................................   

   @RequestMapping(value="/employee/{empId}",method=RequestMethod.DELETE)
   public void deleteEmployee(@PathVariable int empId) {
	   employeeService.deleteEmployee(empId);
	   
   }
   
//............................... get All Departments   ....................................      
   
   @RequestMapping(value="/departments",method=RequestMethod.GET)
   public List<Department> getDepartments(){
	   
	return  departmentService.getDepartments();
	   
   }
   


   


}
