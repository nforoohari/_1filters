package ir.digixo.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
   // @Around("execution(* ir.digixo.controller.MyController.*(..))")
    @Around("@annotation(ir.digixo.annotation.TimeTracker)")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
      long start = System.currentTimeMillis();
      Object proceed = joinPoint.proceed();
      long end = System.currentTimeMillis();
      System.out.println("time elapsed log in aspect: " + (end - start));
      return proceed;
  }
}
