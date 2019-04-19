package com.cg.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.emp.entities.Department;
import com.cg.emp.entities.Employee;
import com.cg.emp.entities.GradeMaster;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
//Employee findByfName(String fName);


	@Query("SELECT e FROM Employee e WHERE e.designation=:designation or e.gradeMaster=:gradeMaster and e.department=:department")
	
	Employee getEmployeeDetails(@Param("designation") String designation,@Param("gradeMaster") GradeMaster gradeMaster,@Param("department") Department department);

	
@Transactional
@Modifying
@Query("UPDATE Employee  a SET a.fName=:fName, a.lName=:lName, a.designation=:designation where a.empId =:empId")
int updateEmployee(@Param(value="empId") int empId,@Param(value="fName") String fName, @Param(value="lName") String lName , @Param(value="designation") String designation);


@Query("SELECT e  FROM Employee e WHERE e.fName LIKE %:fName% ")
List<Employee> getEmployeeByName(@Param(value="fName") String fName);

//come


}
