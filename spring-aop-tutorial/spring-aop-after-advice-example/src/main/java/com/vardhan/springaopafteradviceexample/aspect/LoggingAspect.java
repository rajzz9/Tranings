package com.vardhan.springaopafteradviceexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging execution.
 * 
 * @author Rajavardhan
 *
 */
@Aspect
@Component
public class LoggingAspect {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@After("execution(* com.vardhan.springaopafteradviceexample.service.EmployeeService.*(..))")
    public void logAfterAllMethods(JoinPoint joinPoint) 
    {
		LOGGER.debug("****LoggingAspect.logAfterAllMethods() : " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* com.vardhan.springaopafteradviceexample.service.EmployeeService.getEmployeeById(..))")
    public void logAfterGetEmployee(JoinPoint joinPoint) 
    {
    	LOGGER.debug("****LoggingAspect.logAfterGetEmployee() : " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* com.vardhan.springaopafteradviceexample.service.EmployeeService.addEmployee(..))")
    public void logAfterAddEmployee(JoinPoint joinPoint) 
    {
    	LOGGER.debug("****LoggingAspect.logAfterCreateEmployee() : " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* com.vardhan.springaopafteradviceexample.service.EmployeeService.deleteEmployee(..))")
    public void logAfterDeleteEmployee(JoinPoint joinPoint) 
    {
    	LOGGER.debug("****LoggingAspect.logAfterCreateEmployee() : " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* com.vardhan.springaopafteradviceexample.service.EmployeeService.getAllEmployees(..))")
    public void logAfterGetAllEmployees(JoinPoint joinPoint) 
    {
    	LOGGER.debug("****LoggingAspect.logAfterCreateEmployee() : " + joinPoint.getSignature().getName());
    }
}