package com.practice.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ログ出力クラス
 */
@Component
@Aspect
public class Log {

   
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String START_METHOD = "メソッド開始：";
	private final String SUCSESS_METHOD = "メソッド正常終了：";
	private final String EXCEPTION_METHOD = "メソッド以上終了：";
	

	@Before("execution(* com.practice.*.*.*(..))")
	public void startMethod(JoinPoint jp) {
		logger.info(START_METHOD + jp.getSignature());
	}
	@AfterReturning("execution(* com.practice.*.*.*(..))")
	public void sucsessMethod(JoinPoint jp) {
		logger.info(SUCSESS_METHOD + jp.getSignature());
	}
	@AfterThrowing(value = "execution(* com.practice.*.*.*(..))", throwing="e")
	public void exceptionMethod(JoinPoint jp, Exception e){
		logger.error(EXCEPTION_METHOD + jp.getSignature(), e);
	}
	
}
