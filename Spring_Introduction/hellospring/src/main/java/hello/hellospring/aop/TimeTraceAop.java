package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Start: "+joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("End: "+joinPoint.toString() + " " + (System.currentTimeMillis() - startTime) + "ms");
        }
    }
}
