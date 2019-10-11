package lang.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-19 22:54
 */
public class BiasedLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        ObjectLayoutDemo.A a = new ObjectLayoutDemo.A();

        System.out.println("偏向锁进入同步块前:"+ClassLayout.parseInstance(a).toPrintable());

        Thread thread1 = new Thread(() -> {
            synchronized (a){
                System.out.println("thread1 locking");
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (a){
                //开始撤销， 直接return 模拟偏向锁撤销到未锁定
                return;
            }
        });
        thread1.start();
        //让thread1执行完同步代码块中方法。
        thread1.join();

        System.out.println("thread1's state:" + thread1.isAlive());

        thread2.start();

        System.out.println("after thread2:"+ClassLayout.parseInstance(a).toPrintable());

    }
}
