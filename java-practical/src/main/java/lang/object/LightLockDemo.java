package lang.object;

import org.openjdk.jol.info.ClassLayout;

public class LightLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        ObjectLayoutDemo.A a = new ObjectLayoutDemo.A();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };
        thread1.start();
        //让thread1执行完同步代码块中方法,并退出线程
        thread1.join();


        System.out.println("thread1's state:" + thread1.isAlive());
        thread2.start();
    }
}