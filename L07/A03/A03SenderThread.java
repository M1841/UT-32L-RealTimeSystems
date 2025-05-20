package L07.A03;

import java.util.concurrent.CountDownLatch;

public class A03SenderThread extends Thread {
  private CountDownLatch latch;
  private Object monitor1;
  private Object monitor2;
  private int transitionDelay;
  private int actionDelay;

  public void run() {
    System.out.println(this.getName() + " - STATE 1");
    try {
      Thread.sleep(this.transitionDelay);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    System.out.println(this.getName() + " - STATE 2");
    for (int i = 0; i < this.actionDelay * 100_000; i++) {
      i++;
      i--;
    }
    synchronized (this.monitor1) {
      synchronized (this.monitor2) {
        this.monitor2.notify();
      }
      this.monitor1.notify();
    }

    System.out.println(this.getName() + " - STATE 3");
    try {
      this.latch.countDown();
      this.latch.await();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public A03SenderThread(
      CountDownLatch latch,
      Object monitor1, Object monitor2,
      int transitionDelay, int[] actionDelayRange) {
    this.latch = latch;
    this.monitor1 = monitor1;
    this.monitor2 = monitor2;
    this.transitionDelay = transitionDelay;
    this.actionDelay = this.randomDelay(actionDelayRange[0], actionDelayRange[1]);
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }
}
