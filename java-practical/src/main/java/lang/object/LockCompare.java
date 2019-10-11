package lang.object;

import lang.object.lockbasic.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class LockCompare implements Model {
//    private final Lock BUFFER_LOCK = new ReentrantLock();
    private final Object BUFFER_COND = new Object();
    private final Queue<Task> buffer = new LinkedList<>();
    private final int cap;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);
    public LockCompare(int cap) {
        this.cap = cap;
    }
    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }
    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }
    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {
        @Override
        public void consume() throws InterruptedException {
            synchronized (BUFFER_COND) {
                try {
                    while (buffer.size() == 0) {
                        //await()自然不会重入
                        BUFFER_COND.wait();
                    }
                    Task task = buffer.poll();
                    assert task != null;
                    // 固定时间范围的消费，模拟相对稳定的服务器处理过程
                    Thread.sleep(500 + (long) (Math.random() * 500));
                    System.out.println("consume: " + task.no);
                    BUFFER_COND.notifyAll();
                } finally {
//                    BUFFER_LOCK.unlock();
                }
            }
        }
    }
    private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            synchronized (BUFFER_COND) {
                try {
                    while (buffer.size() == cap) {
                        BUFFER_COND.wait();
                    }
                    Task task = new Task(increTaskNo.getAndIncrement());
                    buffer.offer(task);
                    System.out.println("produce: " + task.no);
                    BUFFER_COND.notifyAll();
                } finally {
//                    BUFFER_LOCK.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        Model model = new LockConditionModel1(3);
        for (int i = 0; i < 1; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}