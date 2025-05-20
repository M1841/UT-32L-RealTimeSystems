package L07.A01;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
  public static void main(String[] args) {
    Semaphore P9 = new Semaphore(1);
    Semaphore P10 = new Semaphore(1);

    while (true) {
      CountDownLatch latch = new CountDownLatch(3);

      A01Thread T1 = new A01Thread(
          latch, P9, P10, new int[] { 2, 4 }, new int[] { 4, 6 }, 4);
      A01Thread T2 = new A01Thread(
          latch, P10, P9, new int[] { 3, 5 }, new int[] { 5, 7 }, 5);

      T1.start();
      T2.start();

      try {
        latch.countDown();
        latch.await();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}
