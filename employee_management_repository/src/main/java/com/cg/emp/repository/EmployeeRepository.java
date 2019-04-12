package com.cg.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.emp.entities.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Transactional
	 @Modifying
	 @Query("UPDATE Employee a SET a.maritalStatus =:maritalStatus, a.address =:address where a.empId =:empId")
	int updateEmployee(@Param("maritalStatus")String maritalStatus, @Param("address")String address,@Param("empId") int empId);
}
