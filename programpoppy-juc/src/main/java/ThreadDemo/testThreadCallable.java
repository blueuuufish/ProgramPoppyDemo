package ThreadDemo;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class testThreadCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CreatingThreadCallable mc = new CreatingThreadCallable();
        FutureTask<Integer> task = new FutureTask<>(() -> {
            Random random = new Random();
            return random.nextInt(100);
        });
        // 创建线程对象
        Thread t = new Thread(task);
        t.start();
        /*
        *
        * */
        Integer result = task.get();
        System.out.println(result);
    }
}
