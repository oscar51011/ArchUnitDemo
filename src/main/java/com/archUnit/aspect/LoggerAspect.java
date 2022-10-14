package com.archUnit.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggerAspect {
	
	@Pointcut("execution(* com.archUnit.controller..*(..))")
    public void pointcut() {
    }
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("===== print log before restful=====");
	    // 執行被關注的 restful
	    Object result = joinPoint.proceed();
	    log.info("===== print log after restful=====");

	    return result;
	}
}
