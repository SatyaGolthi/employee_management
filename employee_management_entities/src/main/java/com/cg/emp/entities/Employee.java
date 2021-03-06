package com.cg.emp.entities;

import java.io.Serializable;
import java.sql.Date;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
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
@SequenceGenerator(name="seq", initialValue=100001, allocationSize=1)
public class Employee implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@Column(name = "EMPID", updatable = false, nullable = false)
	private int empId;
	
	
	@NotNull( message="first name should contain alphabets only")	
	@Pattern(regexp="^[a-z A-Z]*$")
	@Column(name = "FNAME") 
	private String fName;
	
	
	@NotNull (message="last name should contain alphabets only") 
	@Pattern(regexp="^[a-z A-Z]*$")
	@Column(name = "LNAME", nullable = false)
	private String lName;
	
	
	@NotNull
	@Column(name = "DOB")
	@DateTimeFormat(pattern ="yyyy-mm-dd") 
	private Date dateOfbirth;
	
	
	@NotNull	
	@DateTimeFormat(pattern ="yyyy-mm-dd") 
	@Column(name = "DOJ")
	private Date dateOfjoining;
	
	@Pattern(regexp="^[a-z A-Z]*$")
	private String designation;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DEPARTMENT_DEPTID")
	private Department department;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "GRADEMASTER_GRADE")
	private GradeMaster gradeMaster;
	
	
	@NotNull
	@Column(name = "GENDER", nullable = false)
	@Pattern(regexp="Male|Female")
	private String gender;
	
	@Pattern(regexp="Single|Married|Divorced|Seperated|Widowed")
	@Column(name = "MARITAL_STATUS")
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
		return dateOfjoining;
	}

	public void setDateOfjoining(Date dateOfjoining) {
		this.dateOfjoining = dateOfjoining;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public GradeMaster getGradeMaster() {
		return gradeMaster;
	}

	public void setGradeMaster(GradeMaster gradeMaster) {
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