package CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class taskThenCompose {
    private static Integer num = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        });
        // thenCompose方法是用于将当前CompletableFuture的结果传递给另一个返回CompletableFuture的函数，并返回一个新的CompletableFuture。
        CompletableFuture<Integer> future1 = future.thenCompose(i -> CompletableFuture.supplyAsync(() -> i + 1));
        // 主要用途是对前一个CompletableFuture的结果进行转换或处理。
        CompletableFuture<Integer> future2 = future.thenApply(i -> i + 1);
        System.out.println(future.get());
        System.out.println(future1.get());
        System.out.println(future2.get());
    }
}
