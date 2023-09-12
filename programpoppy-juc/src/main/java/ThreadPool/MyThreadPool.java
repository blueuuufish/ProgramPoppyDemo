package ThreadPool;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {
    private final AtomicInteger crl = new AtomicInteger(ctlOf(RUNNING, 0));
    // 线程池线程数地bit数
    private static final int COUNT_BITS = Integer.SIZE - 3;
    // 线程池中最大线程容量
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;


    // 获取线程池地运行状态
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    // 获取有效工作线程地数量
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    // 组装线程数量和线程池状态
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    /*
     * Runnable是一个接口，它有一个run方法，用于定义要执行的任务。通过传递一个Runnable对象，你告诉线程池你想要执行什么任务。
     * ctl 是一个 AtomicInteger 对象。AtomicInteger 是Java并发包 (java.util.concurrent.atomic) 中的一个类，它提供了一个可以原子地更新的 int 值。
     * */
    public void execute(Runnable command) {
        if (command == null) throw new NullPointerException();
        int c = crl.get();
    }

    /*
    * AbortPolicy，抛出RejectedExecutionException异常拒绝任务提交
    * */
    public static class AbortPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +
                    " rejected from " +
                    e.toString());
        }
    }

    public static class DiscardPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {

        }
    }

    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (!threadPoolExecutor.isShutdown()) {
                threadPoolExecutor.getQueue().poll();
                threadPoolExecutor.execute(runnable);
            }
        }
    }

    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                r.run();
            }
        }
    }
}
