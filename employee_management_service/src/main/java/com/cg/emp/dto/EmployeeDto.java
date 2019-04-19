package com.cg.emp.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@SequenceGenerator(name="seq", initialValue=100000, allocationSize=1)
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class EmployeeDto implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private int empId;
	
	
	@NotNull( message="first name should contain alphabets only")	
	@Pattern(regexp="^[a-z A-Z]*$")
	private String fName;
	
	@NotNull( message="first name should contain alphabets only")
	@Pattern(regexp="^[a-z A-Z]*$")
	private String lName;
	
	@NotNull	
	@DateTimeFormat(pattern ="yyyy-mm-dd") 
	@Column(name = "DOB")
	private Date dateOfbirth;
	
	@NotNull
	@DateTimeFormat(pattern ="yyyy-mm-dd") 
	private Date DateOfjoining;	
	
	@Pattern(regexp="^[a-z A-Z]*$")
	private String designation;
	
	private int department;
	
	
	@Pattern(regexp="[M][1-6]")
	private String gradeMaster;
	
	
	@Pattern(regexp="Male|Female")
	private String gender;
	
	@Pattern(regexp="Single|Married|Divorced|Seperated|Widowed")
	private String maritalStatus;
	
	@Column(name = "ADDRESS")
	private String address;
	
	 @Column(name = "MOBILE_NUMBER", nullable = false)
	private long mobileNumber;

}