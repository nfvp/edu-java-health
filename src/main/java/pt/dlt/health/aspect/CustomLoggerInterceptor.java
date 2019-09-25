package pt.dlt.health.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomLoggerInterceptor {

    private Logger LOGGER = Logger.getLogger("Interceptor");

    @Around("@annotation(CustomLogger)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info(joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
    
}
