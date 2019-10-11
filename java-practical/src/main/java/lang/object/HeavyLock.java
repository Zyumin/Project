package lang.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-20 09:58
 */
public class HeavyLock {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        ObjectLayoutDemo.A a = new ObjectLayoutDemo.A();
        Thread thread1 = new Thread(() -> {
            synchronized (a) {
                System.out.println("thread1 locking");
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
                try {
                    //让线程晚点儿死亡，造成锁的竞争
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(ClassLayout.parseInstance(a).toPrintable());

        });
        Thread thread2 = new Thread(() -> {
            synchronized (a) {
                System.out.println("thread2 locking");
                System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
        });
        thread1.start();

        //模拟a从轻量级锁到重量级锁到转变
        Thread.sleep(1000);

        thread2.start();
    }
}
