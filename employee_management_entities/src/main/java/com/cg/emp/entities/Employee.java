package com.cg.emp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPID", updatable = false, nullable = false)
	private int empId;
	
	
	@NotNull( message="first name should contain alphabets only")	
	@Column(name = "FNAME") 
	private String fName;
	
	
	@NotNull (message="last name should contain alphabets only") 
	@Column(name = "LNAME", nullable = false)
	private String lName;
	
	@DateTimeFormat(pattern ="dd-MMM-yy") 
	@NotNull
	@Column(name = "DOJ")
	private Date doj;
	
	//@Column(name = "DEPT_NAME", nullable = false)
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_DEPTID")
	private Department department;
	
	//@Column(name = "GRADE_CODE", nullable = false)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "GRADEMASTER_GRADE")
	private GradeMaster gradeMaster;
	
	
	@NotNull
	@Column(name = "GENDER", nullable = false)
	private String gender;
	
	
	@Column(name = "MARITAL_STATUS")
	private String maritalStatus;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@NotNull
    @Column(name = "MOBILE_NUMBER", nullable = false)
	private double mobileNumber;

}