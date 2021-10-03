package com.vardhan.springaopafterreturningadviceexample.aspect;

import org.aspectj.lang.annotation.AfterReturning;
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
	
	@AfterReturning("execution(* com.vardhan.springaopafterreturningadviceexample.service.EmployeeService.*(..))")
    public void logAfterReturningAllMethods() throws Throwable 
    {
		LOGGER.debug("****LoggingAspect.logAfterReturningAllMethods() ");
    }

    @AfterReturning(pointcut="execution(* com.vardhan.springaopafterreturningadviceexample.service.EmployeeService.getEmployeeById(..))", returning="retVal")
    public void logAfterReturningGetEmployee(Object retVal) throws Throwable 
    {
    	LOGGER.debug("****LoggingAspect.logAfterReturningGetEmployee() ");
    }

    @AfterReturning("execution(* com.vardhan.springaopafterreturningadviceexample.service.EmployeeService.addEmployee(..))")
    public void logAfterReturningAddEmployee() throws Throwable 
    {
    	LOGGER.debug("****LoggingAspect.logAfterReturningAddEmployee() ");
    }
}