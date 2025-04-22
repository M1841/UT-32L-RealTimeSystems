package L04.A02_ReentrantLock;

import java.util.concurrent.locks.Lock;

public class A02Thread extends Thread {
  public A02Thread(
      Lock monitor1,
      Lock monitor2,
      int[] delays1, int[] delays2, int[] delays3) {
    this.monitor1 = monitor1;
    this.monitor2 = monitor2;

    this.delays1 = delays1;
    this.delays2 = delays2;
    this.delays3 = delays3;
  }

  public void run() {
    try {
      System.out.println(this.getName() + " - STATE 1");
      Thread.sleep(this.randomDelay(delays1[0], delays1[1]));

      if (monitor1.tryLock()) {
        System.out.println(this.getName() + " - STATE 2");
        int k = this.randomDelay(delays2[0], delays2[1]);
        for (int i = 0; i < k * 100_000; i++) {
          i++;
          i--;
        }

        if (monitor2.tryLock()) {
          System.out.println(this.getName() + " - STATE 3");
          int j = this.randomDelay(delays3[0], delays3[0]);
          for (int i = 0; i < j * 100_000; i++) {
            i++;
            i--;
          }

          monitor2.unlock();
        }

        monitor1.unlock();
      }

      System.out.println(this.getName() + " - STATE 4");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }

  private Lock monitor1;
  private Lock monitor2;

  private int[] delays1;
  private int[] delays2;
  private int[] delays3;
}
