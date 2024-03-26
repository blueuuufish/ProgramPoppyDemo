package com.programpoppy.asyncTestDemo.simpleDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Bootstrap {
    public static void main (String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        Worker worker = bootstrap.newWorker();

        Wrapper wrapper = new Wrapper();
        wrapper.setWorker(worker);
        wrapper.setParam("hello");

        // 回调方法，输出worker中的内容
        // 这里的超时方法怎么实现
        bootstrap.doWorker(wrapper).addListener(new Listener() {
            @Override
            public void result(Object result) {
               System.out.println(Thread.currentThread().getName());
               System.out.println(result);
            }
        });
        // 通过 Listener 来通知回调
        System.out.println(Thread.currentThread().getName());
        CompletableFuture<Wrapper> f = CompletableFuture.supplyAsync(() -> bootstrap.doWorker(wrapper));
        try {
            f.get(800, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            wrapper.getListener().result("time out exception");
        }

    }

    private Wrapper doWorker(Wrapper wrapper) {
        // 相当于开启新的异步线程，模拟
        new Thread( () -> {
            Worker worker = wrapper.getWorker();
            String result = worker.action(wrapper.getParam());
            wrapper.getListener().result(result);
        }).start();
        return wrapper;
    }


    // 这里有点像service的实现方法，只不过之前的可以通过注入
    private Worker newWorker() {
        return new Worker() {
            @Override
            public String action(String obj) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return obj + " callback!";
            }
        };
    }
}
