package lang.object.lockbasic;

public interface Model {
  Runnable newRunnableConsumer();
  Runnable newRunnableProducer();
}