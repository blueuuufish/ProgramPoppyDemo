package com.programpoppy.asyncTestDemo.JDMarketDemo.Demo1;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;

import java.util.concurrent.ExecutionException;

public class Test2 {
    public static void main(String[] args) {
        WorkerA workerA = new WorkerA();
        WorkerB workerB = new WorkerB();

        /**
         * 包装Worker，编排并行顺序
         */

        //A
        WorkerWrapper wrapperA = new WorkerWrapper.Builder<Integer, Integer>()
                .id("workerA")
                .worker(workerA)
                .callback(workerA)
                .param(1)//1+1
                .build();
        //B
        WorkerWrapper wrapperB = new WorkerWrapper.Builder<Integer, Integer>()
                .id("workerB")
                .worker(workerB)
                .callback(workerB)
                .param(2)//2+2
                .build();
        //C

            //3个WorkerWrapper一起begin
        try {
            Async.beginWork(1000, wrapperA, wrapperB);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
