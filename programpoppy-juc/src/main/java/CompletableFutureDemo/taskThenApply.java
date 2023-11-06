package CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class taskThenApply {
    private static Integer num = 10;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        // 主线程创建一个CompletableFuture对象，该对象会异步执行提供的lambda表达式。
        // 这个异步任务会在ForkJoinPool的默认线程池中执行（除非另外指定）
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("加10任务开始");
                num += 10;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return num;
        // thenApply方法接受一个Function，当CompletableFuture完成时，它会使用这个函数来转换结果
        // 当supplyAsync任务完成时，thenApply中的lambda表达式会自动执行，它会接收到supplyAsync的结果，并进行转换
        }).thenApply(integer -> num * num);
        Integer integer = future.get();
        System.out.println("子线程的结果为： " + integer);
    }
}
