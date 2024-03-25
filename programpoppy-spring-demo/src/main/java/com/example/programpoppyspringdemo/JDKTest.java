package com.example.programpoppyspringdemo;

import java.lang.reflect.Proxy;

public class JDKTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaOImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userDao);
        UserDao userDao1 = (UserDao) Proxy.newProxyInstance(
                JDKTest.class.getClassLoader(),
                new Class[]{UserDao.class},
                myInvocationHandler
        );
    }
}
