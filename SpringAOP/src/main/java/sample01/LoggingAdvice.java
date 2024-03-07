package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class LoggingAdvice {

    public void beforeTrace() {
        System.out.println("before trace");
    } // beforeTrace

    public void afterTrace() {
        System.out.println("after trace");
    } // afterTrace

    public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
        // 앞에 삽입될 코드
        System.out.println("하늘");

        // 핵심코드 메소드 호출
        joinPoint.proceed();

        // 뒤에 삽입될 코드
        System.out.println("땅");
        
    } // trace

} // end class
