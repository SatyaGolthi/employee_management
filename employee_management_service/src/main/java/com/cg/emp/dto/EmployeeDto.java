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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public Date getDateOfjoining() {
		return DateOfjoining;
	}

	public void setDateOfjoining(Date dateOfjoining) {
		DateOfjoining = dateOfjoining;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public String getGradeMaster() {
		return gradeMaster;
	}

	public void setGradeMaster(String gradeMaster) {
		this.gradeMaster = gradeMaster;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	 

}