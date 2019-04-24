package com.cg.emp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "GRADEMASTER")
@Data
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
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

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getMinSal() {
		return minSal;
	}

	public void setMinSal(long minSal) {
		this.minSal = minSal;
	}

	public long getMaxSal() {
		return maxSal;
	}

	public void setMaxSal(long maxSal) {
		this.maxSal = maxSal;
	}

	
}
