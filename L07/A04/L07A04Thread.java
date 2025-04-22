package L07.A04;

import java.util.concurrent.Semaphore;

public class L07A04Thread extends Thread {
  public L07A04Thread(
      Semaphore semaphore,
      int[] actionDelayRange, int transitionDelay) {
    this.semaphore = semaphore;
    this.actionDelay = this.randomDelay(actionDelayRange[0], actionDelayRange[1]);
    this.transitionDelay = transitionDelay;
  }

  public void run() {
    try {
      while (true) {
        System.out.println(this.getName() + " - STATE 1");

        this.semaphore.acquire();
        System.out.println(this.getName() + " - STATE 2");

        int j = this.actionDelay;
        for (int i = 0; i < j * 100_000; i++) {
          i++;
          i--;
        }

        this.semaphore.release();
        System.out.println(this.getName() + " - STATE 3");

        Thread.sleep(this.transitionDelay * 1_000);
        System.out.println(this.getName() + " - STATE 4");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }

  private Semaphore semaphore;
  private int actionDelay;
  private int transitionDelay;
}
