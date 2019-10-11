/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-07-22 16:52
 */
public class NotifyDemo {

    private static Object lock = new Object();

    private static volatile Boolean condition = false;

    public static void main(String[] args) throws InterruptedException {

        Thread waitThread = new Thread(() -> {
            synchronized (lock) {
                while (condition == false) {
                    try {
                        System.out.println("wait");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("gogogogo");

        });


        waitThread.start();

        //等待thread线程被调度
        Thread.sleep(2000);

        synchronized (lock) {
            System.out.println("change");
            //改变条件
            changeCondition();
            //发起通知
            lock.notifyAll();
        }

    }

    private static void changeCondition() {

        condition = condition == true ? false : true;
    }


}
