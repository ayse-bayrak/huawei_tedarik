package com.huawei.aspect;

import com.huawei.entity.Log;
import com.huawei.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    private final LogRepository logRepository;

    public LoggingAspect(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    // Loglama için bir noktaya müdahale ediyoruz (Pointcut).
    @AfterReturning(value = "execution(* com.huawei.service.ModelService.*(..)) || execution(* com.huawei.service.PartService.*(..))",
                    returning = "result")
    public void logAfterServiceMethods(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        
        log.info("Method executed: {}", methodName);
        log.info("Arguments: {}", args);
        log.info("Result: {}", result);

        Log logEntry = new Log();
        logEntry.setTimestamp(LocalDateTime.now());
        logEntry.setMethodName(methodName);
        logEntry.setArguments(Arrays.toString(args));
        logEntry.setResult(result != null ? result.toString() : "null");

        logRepository.save(logEntry);

    }


}
