package L07.A03;

import java.util.concurrent.CountDownLatch;

public class A03ReceiverThread extends Thread {
  private CountDownLatch latch;
  private Object monitor;
  private int transitionDelay;
  private int actionDelay;

  public void run() {
    System.out.println(this.getName() + " - STATE 1");
    try {
      Thread.sleep(this.transitionDelay);
      synchronized (this.monitor) {
        this.monitor.wait();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    System.out.println(this.getName() + " - STATE 2");
    for (int i = 0; i < this.actionDelay * 100_000; i++) {
      i++;
      i--;
    }

    System.out.println(this.getName() + " - STATE 3");
    try {
      this.latch.countDown();
      this.latch.await();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public A03ReceiverThread(
      CountDownLatch latch,
      Object monitor,
      int transitionDelay, int[] actionDelayRange) {
    this.latch = latch;
    this.monitor = monitor;
    this.transitionDelay = transitionDelay;
    this.actionDelay = this.randomDelay(actionDelayRange[0], actionDelayRange[1]);
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }
}
