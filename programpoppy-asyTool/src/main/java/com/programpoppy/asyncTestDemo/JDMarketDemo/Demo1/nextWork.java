package com.programpoppy.asyncTestDemo.JDMarketDemo.Demo1;

import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;

public class nextWork {
    public static void main(String[] args) {
            //引入Worker工作单元
    WorkerA workerA = new WorkerA();
    WorkerB workerB = new WorkerB();
    WorkerC workerC = new WorkerC();

    //A是最后一步，没有next
    WorkerWrapper wrapperA = new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerA")
            .worker(workerA)
            .callback(workerA)
            .param(null)//参数是null，A = B + C
            .build();

    //C next A
    WorkerWrapper wrapperC = new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerC")
            .worker(workerC)
            .callback(workerC)
            .param(3)//3+3 = 6
            .next(wrapperA)
            .build();
    //B next A
    WorkerWrapper wrapperB = new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerB")
            .worker(workerB)
            .callback(workerB)
            .param(2)//2+2 = 4
            .next(wrapperA)
            .build();

    try {new SynchronousQueue<Runnable>();
        //Action
        Async.beginWork(4000, wrapperB, wrapperC);
    } catch (ExecutionException | InterruptedException e) {
        e.printStackTrace();
    }
    }
}
