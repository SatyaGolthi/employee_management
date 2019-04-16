package com.cg.emp.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.cg.exception.EmployeeManagementException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Configuration
public class LoggingAspect {
	
	
	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	 
	private ObjectMapper mapper = new ObjectMapper();
	
	
	@Before("execution(* com.cg.emp.service.GradeMasterServiceImpl.*(..))")
	public void gradelogging(JoinPoint joint) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		try {
			slf4jLogger.info("Start of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Information of Input Data -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new EmployeeManagementException(400, e.getMessage());
		}

	}
	
	@AfterReturning(pointcut = "execution(* com.cg.emp.service.GradeMasterServiceImpl.*(..))", returning = "result")
	public void gradesuccessMethodLogging(JoinPoint joint, Object result) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {

			slf4jLogger.info("Information of Output Data -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new EmployeeManagementException(400, e.getMessage());
		}
	}
	
	@Before("execution(* com.cg.emp.service.DepartmentServiceImpl.*(..))")
	public void departmentlogging(JoinPoint joint) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		try {
			slf4jLogger.info("Start of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Information of Input Data -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new EmployeeManagementException(400, e.getMessage());
		}

	}
	
	@AfterReturning(pointcut = "execution(* com.cg.emp.service.DepartmentServiceImpl.*(..))", returning = "result")
	public void departmentsuccessMethodLogging(JoinPoint joint, Object result) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {

			slf4jLogger.info("Information of Output Data -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new EmployeeManagementException(400, e.getMessage());
		}
	}

	@Before("execution(* com.cg.emp.service.EmployeeServiceImpl.*(..))")
	public void employeeLogging(JoinPoint joint) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		try {
			slf4jLogger.info("Start of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Information of Input Data -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new EmployeeManagementException(400, e.getMessage());
		}

	}

	@AfterReturning(pointcut = "execution(* com.cg.emp.service.EmployeeServiceImpl.*(..))", returning = "result")
	public void employeesuccessMethodLogging(JoinPoint joint, Object result) throws EmployeeManagementException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {

			slf4jLogger.info("Information of Output Data -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new EmployeeManagementException(400, e.getMessage());
		}
	}

}
