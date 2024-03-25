package 面试题;

import java.util.concurrent.TimeUnit;

public class demo1 {
    public static void main (String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                // 线程休眠1s
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        t1.join();
    }
}
