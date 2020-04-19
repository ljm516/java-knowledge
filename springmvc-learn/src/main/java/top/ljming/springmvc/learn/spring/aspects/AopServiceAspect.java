package top.ljming.springmvc.learn.spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 描述类的功能.
 *
 * @author ljming
 */
@Component
@Aspect
public class AopServiceAspect {

    @Pointcut(value = "execution(* top.ljming.springmvc.learn.spring.aop.AopService.aop(..))")
    public void aspect() {
    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before: " + joinPoint);
    }

    @After("aspect()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after: " + joinPoint);
    }

    @Around("aspect()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String arg1 = (String) args[0];
        System.out.println("arg1: " + arg1);

        Object result = joinPoint.proceed(args);
        System.out.println("result: " + result);
    }

    @AfterReturning("aspect()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("afterReturning: " + joinPoint);
    }

    @AfterThrowing(pointcut = "aspect()", throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        System.out.println("afterThrowing: " + joinPoint + "ex: " + ex);
    }
}
