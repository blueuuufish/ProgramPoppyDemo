package Joint;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        // 定义任务
        TaskJoint taskJoint = new TaskJoint(1, 1000);
        // 定义执行对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> result = forkJoinPool.submit(taskJoint);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            forkJoinPool.shutdown();
        }
    }
}
