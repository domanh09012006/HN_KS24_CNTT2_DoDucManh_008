package org.example.hnks24cntt2doducmanh008.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
@Order(1)
public class MenuItemAop {
    @Before("execution(* org.example.hnks24cntt2doducmanh008.controller.MenuItemController.*(..))")
    public void loggingBeforeCallMethod(JoinPoint joinPoint){
        log.info("Phương thức {} được gọi", joinPoint.getSignature().getName());
    }
}