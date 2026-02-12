package programmershinobi.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        try {
            log.info("Around Before {}.{}({})", className, methodName, Arrays.toString(joinPoint.getArgs()));
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info("Around Error {}.{}({})", className, methodName, Arrays.toString(joinPoint.getArgs()));
            return throwable;
        } finally {
            log.info("Around Finnaly {}.{}({})", className, methodName, Arrays.toString(joinPoint.getArgs()));
        }
    }

    @Pointcut("execution(* programmershinobi.aop.service.HelloService.*(java.lang.String))")
    public void pointcutHelloServiceStringParam() {

    }

//    @Before("pointcutHelloServiceStringParam()")
//    public void logStringParameter(JoinPoint joinPoint) {
//        String value = (String) joinPoint.getArgs()[0];
//        log.info("Execute method with parameter : {}", value);
//    }

    @Before("pointcutHelloServiceStringParam() && args(name)")
    public void logStringParameter(String name) {
        log.info("Execute method with parameter : '{}'", name);
    }

    @Pointcut("execution(* programmershinobi.aop.service.*.*(..))")
    public void pointcutServicePackage() {

    }

    @Pointcut("bean(*Service)")
    public void pointcutServiceBean() {

    }

    @Pointcut("execution(public * *(..))")
    public void pointcutPublicMethod() {

    }

    @Pointcut("pointcutServicePackage() && pointcutServiceBean() && pointcutPublicMethod()")
    public void publicMethodForService() {

    }

    @Before("publicMethodForService()")
    public void logAllPublicServiceMethod() {
        log.info("Log for all public methods");
    }

}
