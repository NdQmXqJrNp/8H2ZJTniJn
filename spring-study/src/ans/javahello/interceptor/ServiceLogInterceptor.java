package javahello.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogInterceptor {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Before("execution(* javahello.service..*.*(..))")
	public void invokeBefore(JoinPoint joinPoint) {
		methodLog(joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), "start");
	}

	@After("execution(* javahello.service..*.*(..))")
	public void invokeAfter(JoinPoint joinPoint) {
		methodLog(joinPoint.getTarget().getClass().toString(), joinPoint.getSignature().getName(), "end");
	}

	private void methodLog(String className, String methodName, String message) {
		logger.info(className + "." + methodName + "() " + message + ".");
		System.out.println(className + "." + methodName + "() " + message + ".");
	}
}