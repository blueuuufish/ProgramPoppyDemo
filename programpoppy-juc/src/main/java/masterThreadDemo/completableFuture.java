package masterThreadDemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class completableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> thread = CompletableFuture.runAsync(() -> {
            System.out.println("new Thread");
        });
        System.out.print(thread.get());
    }
}
