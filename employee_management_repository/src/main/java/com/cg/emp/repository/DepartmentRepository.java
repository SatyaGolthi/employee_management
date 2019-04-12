package com.cg.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.emp.entities.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}

