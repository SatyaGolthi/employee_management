package com.cg.emp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class EmployeeDto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	private String fName;
	
	private String lName;
	
	private Date doj;	
	
	private int department;
	
	private String gradeMaster;
	
	private String gender;
	
	private String maritalStatus;
	
	private String address;
	
	private double mobileNumber;

}