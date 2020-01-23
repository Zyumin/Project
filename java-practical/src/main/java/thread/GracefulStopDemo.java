package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-06-16 09:42
 */
public class GracefulStopDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(1,1,10,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue(10));

//        Thread worker = new Thread(new Worker());
//        worker.start();
//        threadPoolExecutor.execute(worker);
        threadPoolExecutor.execute(new Worker());

//        Thread.currentThread().wait(1);

        Thread.sleep(2000);
        System.err.println("shutdown");
        threadPoolExecutor.shutdownNow();

//        Object object = new Object();
        threadPoolExecutor.shutdown();

//        threadPoolExecutor.shutdownNow();
    }

    public static class Worker implements Runnable {
//        private volatile boolean stopFlag =  false;
//        public void stop(){
//            stopFlag = true;
//        }
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("i'm running "+Thread.currentThread().getName());

            }
        }
    }

//    public static class Worker implements Runnable{
//
//        @Override
//        public void run() {
//
//                while(true){
//
////                    Object object = new Object();
//                    System.out.println("i'm running "+Thread.currentThread().getName());
//                    System.out.println("interrupted:"+Thread.currentThread().isInterrupted());
//
//
////                        try {
////                            Thread.sleep(10000);
////                        } catch (Exception e) {
////                            System.out.println("interrupted:"+Thread.currentThread().isInterrupted());
////
////                            e.printStackTrace();
////                        }
//
//
//                    System.out.println("interrupted:"+Thread.currentThread().isInterrupted());
//
//
//
//
//                    if(Thread.currentThread().isInterrupted()){
//                        System.out.println("stop");
//                        break;
//                    }
////                    throw new RuntimeException();
//
//                }
//        }
//    }
}
