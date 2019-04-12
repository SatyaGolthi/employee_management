package com.cg.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.emp.entities.Department;

import com.cg.emp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public Department addDepartment(Department departments) {
	
		return deptRepo.save(departments);
	}

	@Override
	public List<Department> getDepartments() {
		
		return deptRepo.findAll();
	}

	
}


