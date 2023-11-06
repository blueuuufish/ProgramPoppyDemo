package ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class DemoCallable {
    public static class MyThread1 implements Callable<Long>{
        @Override
        public Long call() throws Exception {
            try {
                System.out.println(Thread.currentThread().getName() + "线程进入了call方法,开始准备睡觉");
                        Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "睡醒了");
            }catch (Exception e){
                e.printStackTrace();
            }
            return System.currentTimeMillis();
        }
    }
    public static void main(String[] args) {
        Callable<Long> callable = new MyThread1();
        FutureTask<Long> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            // 获取call方法的返回值
            Long result = futureTask.get();
            System.out.println("返回的结果是: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
