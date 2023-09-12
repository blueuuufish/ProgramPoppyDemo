package ThreadDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class testThreadPoolFactory implements ThreadFactory {

    private AtomicInteger threadIdx = new AtomicInteger(0);
    private String threadNamePrefix;

    public testThreadPoolFactory(String prefix) {
        threadNamePrefix = prefix;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(threadNamePrefix + "-program poppy-" + threadIdx.getAndIncrement());
        return null;
    }

    public void cacheThreadPoolTest() {
        ExecutorService executorService = Executors.newCachedThreadPool(new testThreadPoolFactory("cachedThread"));
        for (int i = 0; i < 10; i++) {
            executorService.submit(() ->  {
                System.out.println("cachedThreadPool");
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
