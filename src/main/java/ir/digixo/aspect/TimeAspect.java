package ir.digixo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    //    @Around("execution(* ir.digixo.controller.MyController.*(..))")
    @Around("@annotation(ir.digixo.annotation.TimeTracker)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("An Aspect was started.");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time logging in Aspect: " + (end - start));
        return proceed;
    }
}
