package lang;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-29 11:20
 */
public class MainThreadInfoDemo {
    public static void main(String[] args) {
//        threadCreateExample();
        dumpThreadInfo();

    }

    public static void dumpThreadInfo() {
        Arrays.stream(ManagementFactory.getThreadMXBean().dumpAllThreads(false, false)).
                forEach(threadInfo -> System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName())
                );
    }

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

        new Thread(() -> { System.out.println("impl");while (true) { } }).start();
    }
}
