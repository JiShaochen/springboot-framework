package com.shaochen.common.tools.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class CheckTokenAop {

    @Around(value = "execution (* com.shaochen.controller..*.*(..))")
    public Object checkTokenAndInjectUser(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return  proceedingJoinPoint.proceed();
    }
}