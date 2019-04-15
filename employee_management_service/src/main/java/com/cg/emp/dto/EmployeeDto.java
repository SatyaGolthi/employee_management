package com.cg.emp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@SequenceGenerator(name="seq", initialValue=100000, allocationSize=1)
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class EmployeeDto implements Serializable{
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private int empId;
	
	@NotNull( message="first name should contain alphabets only")	
	@Pattern(regexp="[A-Z a-z]")
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