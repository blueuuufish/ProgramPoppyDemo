package CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TaskCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "子线程开始干活");
                Thread.sleep(5000);
                future.complete("success");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A").start();
        // future.get()会阻塞主线程，直到CompletableFuture完成。
        // 当异步任务在"A"线程中完成后，future.get()会返回结果（在这种情况下是"success"）。
        System.out.println("主线程调用 get 方法获取结果为: " + future.get());
        System.out.println("主线程完成,阻塞结束!!!!!!");

    }
}
