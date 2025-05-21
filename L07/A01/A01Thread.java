package L07.A01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class A01Thread extends Thread {
  private CountDownLatch latch;
  private Semaphore semaphore1;
  private Semaphore semaphore2;
  private int actionDelay1;
  private int actionDelay2;
  private int transitionDelay;

  public void run() {
    System.out.println(this.getName() + " - STATE 1");
    for (int i = 0; i < this.actionDelay1 * 100_000; i++) {
      i++;
      i--;
    }

    if (this.semaphore1.tryAcquire()) {
      try {
        System.out.println(this.getName() + " - STATE 2");
        for (int i = 0; i < this.actionDelay2 * 100_000; i++) {
          i++;
          i--;
        }

        if (this.semaphore2.tryAcquire()) {
          try {
            System.out.println(this.getName() + " - STATE 3");
            Thread.sleep(this.transitionDelay * 1_000);
          } catch (Exception ex) {
            ex.printStackTrace();
          } finally {
            this.semaphore2.release();
          }
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      } finally {
        this.semaphore1.release();
      }
    }

    System.out.println(this.getName() + " - STATE 4");
    try {
      this.latch.countDown();
      this.latch.await();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public A01Thread(
      CountDownLatch latch,
      Semaphore semaphore1, Semaphore semaphore2,
      int[] actionDelay1Range, int[] actionDelay2Range,
      int transitionDelay) {
    this.latch = latch;

    this.semaphore1 = semaphore1;
    this.semaphore2 = semaphore2;

    this.actionDelay1 = this.randomDelay(actionDelay1Range[0], actionDelay1Range[1]);
    this.actionDelay2 = this.randomDelay(actionDelay2Range[0], actionDelay2Range[1]);

    this.transitionDelay = transitionDelay;
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }
}
