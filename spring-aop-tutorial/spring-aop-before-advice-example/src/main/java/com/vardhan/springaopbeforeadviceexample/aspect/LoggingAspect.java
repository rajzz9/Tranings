package com.vardhan.springaopbeforeadviceexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

	@Before("execution(* com.vardhan.springaopbeforeadviceexample.service.EmployeeService.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint) {
		LOGGER.debug("****LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.vardhan.springaopbeforeadviceexample.service.EmployeeService.getEmployeeById(..))")
	public void logBeforeGetEmployee(JoinPoint joinPoint) {
		LOGGER.debug("****LoggingAspect.logBeforeGetEmployee() : " + joinPoint.getSignature().getName());
	}

	@Before("execution(* com.vardhan.springaopbeforeadviceexample.service.EmployeeService.createEmployee(..))")
	public void logBeforeAddEmployee(JoinPoint joinPoint) {
		LOGGER.debug("****LoggingAspect.logBeforeCreateEmployee() : " + joinPoint.getSignature().getName());
	}
}