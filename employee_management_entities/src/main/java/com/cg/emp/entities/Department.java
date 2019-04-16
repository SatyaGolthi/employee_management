package com.cg.emp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Department {
	
	
	@Id
	@Column(name="DEPT_ID")
	private int deptId;
	
	
	@Column(name="DEPT_NAME")
	private String deptName;

	

}
