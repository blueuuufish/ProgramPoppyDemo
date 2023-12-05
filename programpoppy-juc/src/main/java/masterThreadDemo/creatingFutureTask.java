package masterThreadDemo;

import java.util.concurrent.*;

public class creatingFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        // Thread只支持futureTask，所以需要传入futureTask
        new Thread(futureTask, "t1").start();
        System.out.println(futureTask.get(3, TimeUnit.SECONDS));
        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("-----already in----");
        return "hello Callable";
    }
}
