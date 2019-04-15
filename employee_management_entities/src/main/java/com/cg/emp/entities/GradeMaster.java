package com.cg.emp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "GRADEMASTER")
@Data
public class GradeMaster {
	
	
	@Id
	@Column(name="GRADE")
	private String gradeCode;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="MINSAL")
	private long  minSal;
	
	@Column(name="MAXSAL")
	private long maxSal;

	
}
