package ThreadDemo.juc0220;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class atguiguDemo {
}

class Ticket {
    private int number = 30;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    public void sale() {
        reentrantLock.lock();
        try {
            if (number > 0) System.out.println(number--);
        } finally {
            reentrantLock.unlock();
        }
    }
}

class DemoClass {
    //通信对象:0--打印 A 1---打印 B 2----打印 C
    private int number = 0;
    //声明锁
    private Lock lock = new ReentrantLock();
    //声明钥匙 A
    private Condition conditionA = lock.newCondition();
    //声明钥匙 B
    private Condition conditionB = lock.newCondition();
    //声明钥匙 C
    private Condition conditionC = lock.newCondition();

    public void printA (int j) {
        try {
            lock.lock();
            while (number != 0) conditionA.await();
            System.out.println(Thread.currentThread().getName() + "输出 A,第" + j + " 轮开始");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}