package CompletableFutureDemo;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class taskThenAccept {
    private static Integer num = 0;
    public static void main(String[] args) {
        System.out.println("start");
        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("加 10 任务开始");
                num += 10;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return num;
        }).thenApply(integer -> num * num).thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("the result of accept: " + integer);
            }
        });
    }
}
