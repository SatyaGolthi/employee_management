package com.cg.emp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
public class Department {
	
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int empId; */
	
	@Id
	@Column(name="DEPT_ID")
	private int deptId;
	
	
	@Column(name="DEPT_NAME")
	private String deptName;

/*	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	} */


	
	

}
