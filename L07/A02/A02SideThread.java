package L07.A02;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class A02SideThread extends Thread {
  private CyclicBarrier barrier;
  private ReentrantLock lock;
  private int actionDelay;
  private int transitionDelay;

  public void run() {
    System.out.println(this.getName() + " - STATE 1");
    if (lock.tryLock()) {
      try {
        System.out.println(this.getName() + " - STATE 2");
        for (int i = 0; i < this.actionDelay * 100_000; i++) {
          i++;
          i--;
        }
        Thread.sleep(this.transitionDelay);
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        lock.unlock();
      }
    }

    System.out.println(this.getName() + " - STATE 3");
    try {
      this.barrier.await();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public A02SideThread(
      CyclicBarrier barrier, ReentrantLock lock,
      int[] actionDelayRange, int transitionDelay) {
    this.barrier = barrier;
    this.lock = lock;
    this.actionDelay = this.randomDelay(actionDelayRange[0], actionDelayRange[1]);
    this.transitionDelay = transitionDelay;
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }
}
