package com.cg.emp.controller;


import java.util.List;

import javax.validation.Valid;

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
import com.cg.exception.EmployeeManagementException;


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
	public Department addDepartment(@RequestBody Department department) throws EmployeeManagementException {

		try {
		return departmentService.addDepartment(department);
	}
		catch(Exception e) {
			throw new EmployeeManagementException(400,e.getMessage());
		}
	}
		
	
	//............................... add GradeMaster .....................................

	@RequestMapping(value="/grademaster", method = RequestMethod.POST)
	public GradeMaster addGradeMaster( @RequestBody GradeMaster grademaster) throws EmployeeManagementException {
		System.out.println(grademaster.toString());
		try {
		return grademasterService.addGradeMaster(grademaster);
	}
		catch(Exception e) {
			throw new EmployeeManagementException(400,e.getMessage());
		}
	}

	//............................... add Employee .....................................

	@RequestMapping(value="/employee",method=RequestMethod.POST)
	public Employee addEmployee(@RequestBody @Valid EmployeeDto employee)  throws EmployeeManagementException {

		try {
		return employeeService.addEmployee(employee/*,empId*/);
	}
		catch(Exception e) {
			throw new EmployeeManagementException(400,e.getMessage());
		}
	}

	
	//............................... get EmployeeDetails by id.....................................
   @RequestMapping(value="/employee/{empId}",method=RequestMethod.GET)
	public Employee getEmployee(@PathVariable int empId)throws EmployeeManagementException
   {
    try {
	return employeeService.getEmployee(empId);
	   
   }
	catch(Exception e) {
		throw new EmployeeManagementException(204,e.getMessage());
	}
}
   
   
	//............................... get EmployeeDetails by fName.....................................
   @RequestMapping(value="/employe/{fName}",method=RequestMethod.GET)
	public List<Employee> getEmployeeByName(@PathVariable String fName)throws EmployeeManagementException
   {
	 try {
	return employeeService.getEmployeeByName(fName);
	   
   }
	catch(Exception e) {
		throw new EmployeeManagementException(204,e.getMessage());
	}
}
   
 //............................... get AllEmployees   ....................................
   
   @RequestMapping(value="/employees",method=RequestMethod.GET)
   public List<Employee> getEmployees()throws EmployeeManagementException{
	  try { 
	   return employeeService.getEmployees();
	  }
		catch(Exception e) {
			throw new EmployeeManagementException(204,e.getMessage());
		}
	}
	   


   
//............................... delete Employee by Id   ....................................   

   @RequestMapping(value="/employee/{empId}",method=RequestMethod.DELETE)
   public void deleteEmployee(@PathVariable int empId) {
	   try {
	   employeeService.deleteEmployee(empId);
	   }
		catch(Exception e) {
			throw new EmployeeManagementException(204,e.getMessage());
		}
	}
	   
   
   
   
//............................... Update Employee by Id   ....................................   

   
   @RequestMapping(value = "/employee/{empId}", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee,@PathVariable int empId) {
	try {	return employeeService.updateEmployee(employee,empId);
	}
	catch(Exception e) {
		throw new EmployeeManagementException(500,e.getMessage());
	}
}
   
 //.............. get Employee Details by designation,gradeMaster,department   .................................... 
   
   
   @RequestMapping(value="/employeeDetails/{designation}/{gradeMaster}/{department}")
   public Employee getEmployeeDetails(@PathVariable String designation,@PathVariable String gradeMaster,@PathVariable int department) {
	  try { 
	   return employeeService.getEmployeeDetails(designation, gradeMaster, department);
   }
	catch(Exception e) {
		throw new EmployeeManagementException(204,e.getMessage());
	}
}
   
   
//............................... get All Departments   ....................................      
   
   @RequestMapping(value="/departments",method=RequestMethod.GET)
   public List<Department> getDepartments(){
	try {   
	return  departmentService.getDepartments();
	   
   }
	catch(Exception e) {
		throw new EmployeeManagementException(204,e.getMessage());
	}
}
   


   


}
