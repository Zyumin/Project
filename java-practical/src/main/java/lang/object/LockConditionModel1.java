package lang.object;

import lang.object.lockbasic.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionModel1 implements Model {
  private final Lock BUFFER_LOCK = new ReentrantLock();
  private final Condition BUFFER_COND = BUFFER_LOCK.newCondition();
  private final Queue<Task> buffer = new LinkedList<>();
  private final int cap;
  private final AtomicInteger increTaskNo = new AtomicInteger(0);
  public LockConditionModel1(int cap) {
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
      System.out.println(Thread.currentThread().isInterrupted());

      BUFFER_LOCK.lockInterruptibly();
      try {

        while (buffer.size() == 0) {
          //await()自然不会重入
          BUFFER_COND.awaitUninterruptibly();
        }
        Task task = buffer.poll();
        assert task != null;
        // 固定时间范围的消费，模拟相对稳定的服务器处理过程
//        Thread.sleep(500 + (long) (Math.random() * 500));
        System.out.println("consume: " + task.no);
        BUFFER_COND.signalAll();
      } catch (Exception e){
        e.printStackTrace();
      }
        finally {
        BUFFER_LOCK.unlock();
      }
    }
  }
  private class ProducerImpl extends AbstractProducer implements Producer, Runnable {
    @Override
    public void produce() throws InterruptedException {
      // 不定期生产，模拟随机的用户请求
      Thread.sleep((long) (Math.random() * 1000));
      BUFFER_LOCK.lock();
      try {
        while (buffer.size() == cap) {
          BUFFER_COND.await();
        }
        Task task = new Task(increTaskNo.getAndIncrement());
        buffer.offer(task);
        System.out.println("produce: " + task.no);
        BUFFER_COND.signalAll();
      } catch (Exception e){
        e.printStackTrace();
      }finally {
        BUFFER_LOCK.unlock();
      }
    }
  }
  public static void main(String[] args) {
    Model model = new LockConditionModel1(3);
    Thread a  = null;
    for (int i = 0; i < 1; i++) {
       a = new Thread(model.newRunnableConsumer());
      a.start();

    }
    for (int i = 0; i < 5; i++) {
      new Thread(model.newRunnableProducer()).start();
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.err.println(a.isInterrupted());
    a.interrupt();
    System.err.println(a.isInterrupted());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.err.println(a.isInterrupted());


  }
}