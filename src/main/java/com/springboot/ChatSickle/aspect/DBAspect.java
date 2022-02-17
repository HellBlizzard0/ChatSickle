package com.springboot.ChatSickle.aspect;

import com.springboot.ChatSickle.DAO.UserDAO;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DBAspect {
    @Before("execution(* com.springboot.ChatSickle.*.*.*(..))")
    public String checkConnection() {
        System.out.println("com.springboot.ChatSickle.aspect.DBAspect.checkConnection()");
        return "success";
    }
}
