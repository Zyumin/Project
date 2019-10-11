package everyday;

public class Lazy {

    private static boolean initialized = false;

    static {
        Thread t = new Thread(() -> {
            initialized = true;
            System.out.println("thread run:" + Thread.currentThread().getName());
        });
        t.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static run");
//        try {
//            t.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        System.out.println("first: " + initialized);
        System.out.println("second: " + initialized);
    }
}