package com.example.programpoppyspringdemo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Component
@Aspect
public class MyAop {
    @Pointcut("execution(public * com.example.programpoppyspringdemo.HelloController.hello())")
    public void log(){
        System.out.println("pointCut签名。。。");
    }

        //前置通知
    @Before("log()")
    public void deBefore(JoinPoint jp) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("CLASS_METHOD : " + jp);
        System.out.println("ARGS : " + Arrays.toString(jp.getArgs()));
        System.out.println("前置通知：方法执行前执行...");
    }
    //返回通知
    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("返回通知：方法的返回值 : " + ret);
    }

    //异常通知
    @AfterThrowing(throwing = "ex", pointcut = "log()")
    public void throwss(JoinPoint jp, Exception ex) {
        System.out.println("异常通知：方法异常时执行.....");
        System.out.println("产生异常的方法：" + jp);
        System.out.println("异常种类：" + ex);
    }

    //后置通知
    @After("log()")
    public void after(JoinPoint jp){
        System.out.println("后置通知：最后且一定执行.....");
    }

}
