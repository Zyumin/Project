package juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-16 09:33
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        try {
            System.out.println("do something");

        }finally {
            lock.unlock();
        }

        System.out.println("over");
    }
}
