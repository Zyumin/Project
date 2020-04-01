package lang.object;

import java.lang.ref.WeakReference;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-20 09:58
 */
public class WeakRef {

    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(5000);
//        ObjectLayoutDemo.A a = ;

//        Thread thread1 = new Thread(){
//            @Override
//            public void run() {
//                synchronized (a){
//                    System.out.println("thread1 locking");
//                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
//                    try {
//                        //让线程阻塞，造成锁的竞争
//                        a.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };


//        Thread thread2 = new Thread(){
//            @Override
//            public void run() {
//                synchronized (a){
//                    System.out.println("thread2 locking");
//                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread1.start();
//        Thread.sleep(1000);
//        System.out.println(ClassLayout.parseInstance(wa).toPrintable());
//
//
//        System.gc();
//
//        Thread.sleep(2000);
//        System.out.println(ClassLayout.parseInstance(wa).toPrintable());
//
//        int _1MB = 1024 * 1024;
//        byte[] allocation1, allocation2, allocation3, allocation4;
//        allocation1 = new byte[2 * _1MB];
//        allocation2 = new byte[2 * _1MB];
        //1kb = 1000 byte  = 8000bit
        WeakReference <ObjectLayoutDemo.A> wa =  new  WeakReference(new ObjectLayoutDemo.A());

        int i = 0;
        System.gc();
        System.out.println("gc");
//        System.runFinalization();

        while(true){
            if(wa.get()!=null){
                i++;
//                allocation2 = new byte[10 * _1MB];

                System.out.println("Object is alive for "+i+" loops - "+wa);

            }else{
                System.out.println("Object has been collected.");
                break;
                //               System.out.println(ClassLayout.parseInstance(wa).toPrintable());
//                System.out.println(ClassLayout.parseInstance(a).toPrintable());

//                break;
            }
        }



//        thread2.start();
    }
}
