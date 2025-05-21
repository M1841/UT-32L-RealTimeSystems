package L07.A02;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class A02MidThread extends Thread {
  private CyclicBarrier barrier;
  private ReentrantLock lock1;
  private ReentrantLock lock2;
  private int actionDelay;
  private int transitionDelay;

  public void run() {
    System.out.println(this.getName() + " - STATE 1");
    if (lock1.tryLock()) {
      try {
        if (lock2.tryLock()) {
          try {
            System.out.println(this.getName() + " - STATE 2");
            for (int i = 0; i < this.actionDelay * 100_000; i++) {
              i++;
              i--;
            }
            Thread.sleep(this.transitionDelay * 1_000);
          } catch (Exception ex) {
            ex.printStackTrace();
          } finally {
            lock2.unlock();
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        lock1.unlock();
      }
    }

    System.out.println(this.getName() + " - STATE 3");
    try {
      this.barrier.await();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public A02MidThread(
      CyclicBarrier barrier, ReentrantLock lock1, ReentrantLock lock2,
      int[] actionDelayRange, int transitionDelay) {
    this.barrier = barrier;
    this.lock1 = lock1;
    this.lock2 = lock2;
    this.actionDelay = this.randomDelay(actionDelayRange[0], actionDelayRange[1]);
    this.transitionDelay = transitionDelay;
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }
}
