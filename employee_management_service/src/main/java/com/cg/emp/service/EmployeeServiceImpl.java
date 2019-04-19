package com.cg.emp.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.emp.dto.EmployeeDto;
import com.cg.emp.entities.Department;
import com.cg.emp.entities.Employee;
import com.cg.emp.entities.GradeMaster;
import com.cg.emp.repository.DepartmentRepository;
import com.cg.emp.repository.EmployeeRepository;
import com.cg.emp.repository.GradeMasterRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {


	
	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	GradeMasterRepository gradeRepo;

	@Autowired
	DepartmentRepository deptRepo;

	@Override
	public Employee addEmployee(EmployeeDto employeeDto) {

		

		Employee employee = new Employee();
		employee.setFName(employeeDto.getFName());
		employee.setLName(employeeDto.getLName());
		employee.setDateOfbirth(employeeDto.getDateOfbirth());
		employee.setDateOfjoining(employeeDto.getDateOfjoining());
		employee.setDesignation(employeeDto.getDesignation());
		employee.setGender(employeeDto.getGender());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setAddress(employeeDto.getAddress());
		employee.setMobileNumber(employeeDto.getMobileNumber());			
		employee.setDepartment(deptRepo.getOne(employeeDto.getDepartment()));
		employee.setGradeMaster(gradeRepo.getOne(employeeDto.getGradeMaster()));
		return empRepo.save(employee);
	}

	@Override
	public Employee getEmployee(int empId) {
		
		return empRepo.getOne(empId);

	}
	
	@Override
	public List<Employee> getEmployeeByName(String fName) {
		
		return empRepo.getEmployeeByName(fName);
	}


	@Override
	public List<Employee> getEmployees() {

		return empRepo.findAll();
	}


	public void deleteEmployee(int empId) {
		empRepo.deleteById(empId);
		
	}
	
	@Override
	public Employee updateEmployee(Employee employee, int empId) {
		Employee empUpdate = (Employee) empRepo.getOne(empId);
		empUpdate.setFName(employee.getFName());
		empUpdate.setLName(employee.getLName());
		empUpdate.setDesignation(employee.getDesignation());			
		return empRepo.saveAndFlush(empUpdate);
	}


	public Employee getEmployeeDetails(String designation,String gradeMaster,int department) {
		return empRepo.getEmployeeDetails( designation, gradeRepo.getOne(gradeMaster),deptRepo.getOne(department));
	}


	

}



