package com.programpoppy.asyncTestDemo.JDMarketDemo.Demo1;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;

public class Test {

    public static void main(String[] args) {
        //引入Worker工作单元
        WorkerA workerA = new WorkerA();
        WorkerB workerB = new WorkerB();
        WorkerC workerC = new WorkerC();

        //C是最后一步，它没有next
        WorkerWrapper wrapperC = new WorkerWrapper.Builder<Integer, Integer>()
                .id("workerC")
                .worker(workerC)
                .callback(workerC)
                .param(null)//没有参数，根据A的返回值+3
                .build();
        //B是最后一步，它没有next
        WorkerWrapper wrapperB = new WorkerWrapper.Builder<Integer, Integer>()
                .id("workerB")
                .worker(workerB)
                .callback(workerB)
                .param(null)//没有参数，根据A的返回值+2
                .build();
        //A的next是B、C
        WorkerWrapper wrapperA = new WorkerWrapper.Builder<Integer, Integer>()
                .id("workerA")
                .worker(workerA)
                .callback(workerA)
                .param(1)//1+1
                //next是B、C
                .next(wrapperB, wrapperC)
                .build();


        try {
            //Action
            Async.beginWork(1000, wrapperA);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
