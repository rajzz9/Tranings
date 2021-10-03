package com.vardhan.springaopafterthrowingadviceexample.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* com.vardhan.springaopafterthrowingadviceexample.service.EmployeeService.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable {
        LOGGER.debug("****LoggingAspect.logAfterThrowingAllMethods() " + ex);
    }
}
