package com.example.programpoppyspringdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private UserDao target;

    public MyInvocationHandler(UserDao target) {
        this.target =target;
    }

    //若省略invoke()方法会报错，需要自行完成具体的代码体，方法框架可以一键生成，如下文
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在方法调用前执行一些操作
        System.out.println("Before invoking method: " + method.getName());

        // 调用目标对象的方法
        Object result = method.invoke(target, args);

        // 在方法调用后执行一些操作
        System.out.println("After invoking method: " + method.getName());

        return result;
    }
}
