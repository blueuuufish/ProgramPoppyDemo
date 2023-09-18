package programpoppy.testDemo;

import cn.hutool.core.date.SystemClock;
import com.jd.platform.async.executor.Async;
import com.jd.platform.async.wrapper.WorkerWrapper;
import parallel.ParWorker;
import parallel.ParWorker1;
import parallel.ParWorker2;

import java.util.concurrent.ExecutionException;

public class quickStartDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ParWorker w = new ParWorker();
        ParWorker1 w1 = new ParWorker1();
        ParWorker2 w2 = new ParWorker2();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .callback(w1)
                .param("1")
                .build();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .callback(w)
                .param("0")
                .build();

        long now = SystemClock.now();
        System.out.println("begin------" + now);
        Async.beginWork(1500, workerWrapper, workerWrapper1, workerWrapper2);
        System.out.println("end---------------" + SystemClock.now());
        System.err.println("cost---------------" + (SystemClock.now() - now));
        System.out.println(Async.getThreadCount());

        System.out.println(workerWrapper.getWorkResult());
        Async.shutDown();
    }
}
