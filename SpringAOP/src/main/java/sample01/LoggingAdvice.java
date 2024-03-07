package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice {

    public void beforeTrace() {
        System.out.println("before trace");
    } // beforeTrace

    public void afterTrace() {
        System.out.println("after trace");
    } // afterTrace

    public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
        // 앞에 삽입될 코드
//        System.out.println("하늘");
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("메소드 : " +methodName);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 핵심코드 메소드 호출
        joinPoint.proceed();

        // 뒤에 삽입될 코드
        System.out.println("땅");

        stopWatch.stop();
        System.out.println("처리 시간 : " + stopWatch.getTotalTimeMillis() / 1000 + "초");

    } // trace

} // end class
