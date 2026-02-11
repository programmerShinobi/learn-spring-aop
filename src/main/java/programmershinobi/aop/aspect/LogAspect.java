package programmershinobi.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("target(programmershinobi.aop.service.HelloService)")
    public void helloServiceMethod() {

    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("Before " + className + "." + methodName + "(" + Arrays.toString(args) + ")");
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethodAgain() {
        log.info("Before HelloService Method Again");
    }

}
