package lang;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-28 10:01
 */
public class ThreadDemo {


    public static void main(String[] args) {
//        threadCreateExample();
    Lock lock = new ReentrantLock();
    Condition c = lock.newCondition();

//        dumpThreadInfo();
        dumpMethod();
     lock.lock();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    Lock lock = new ReentrantLock();
//    Condition c = lock.newCondition();
    //        lock.lock();
//        try {
//            c.await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("a");

    public static void dumpThreadInfo() {
        Arrays.stream(
                ManagementFactory.
                        getThreadMXBean().
                        dumpAllThreads(false, false)).
                forEach(threadInfo -> System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName())
                );

    }

    public static void dumpMethod() {


//        System.out.println(Thread.activeCount());
//        Thread.dumpStack();
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

        int i = 0;
//        while (i < 1000) {
        map.forEach((thread, stackTraceElements) -> {
//                if (!"Monitor Ctrl-Break".equals(thread.getName())) {
//                    ;
//                } else {
            System.out.println("thread name:" + thread.getName() + ",\tthread id:" + thread.getId() + ",\t daemon:" + thread.isDaemon());
//                    for (StackTraceElement s : stackTraceElements) {
//                        System.err.println(s);
//
//                    }
//                }
        });
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
    }


//    }

    static long time = 10000;

    /**
     * 线程创建example
     */
    public static void threadCreateExample() {

        class DemoThread extends Thread {
            @Override
            public void run() {
                System.out.println("extend");
                while (true) {

                }

            }
        }
        new DemoThread().start();


        Thread t = new Thread(() -> {
            System.out.println("impl");
            while (true) {

            }
        });
        t.start();
    }

    //        System.out.println(t.getId());
    //        AbstractExecutorService executor = (AbstractExecutorService) Executors.newSingleThreadExecutor();
//
//        executor.execute(runnable);
//
//        System.out.println("end1");

    public static void uncaught() {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("[caught]:" + t.getName() + " dump,msg:");
            e.printStackTrace();
        });


        new Thread(() -> {
            System.out.println("a");
            throw new RuntimeException("test", new Throwable("test"));
        }).start();

        System.out.println("end");

    }
}
