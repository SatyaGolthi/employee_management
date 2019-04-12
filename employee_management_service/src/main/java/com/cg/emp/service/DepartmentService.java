package com.cg.emp.service;

import java.util.List;

import com.cg.emp.entities.Department;

public interface DepartmentService {

	public Department addDepartment(Department departments);
	
	public List<Department> getDepartments();
}
