package com.example.programpoppyspringdemo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TestAspect {
    @Pointcut("execution(public void com.example.programpoppyspringdemo.UserDaOImpl.saveUser())")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("使用前检查是否满足条件？");
    }

    @Pointcut("execution(public void com.example.programpoppyspringdemo.UserDaoImpl.deleteUser())")
    public void pointcut1(){}

    @AfterReturning("pointcut1()")
    public void afterResult(){
        System.out.println("调用结束后返回日志结果，进行记录");
    }
}
