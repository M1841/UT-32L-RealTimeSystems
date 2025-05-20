package L07.A03;

import java.util.concurrent.CountDownLatch;

public class Main {
  public static void main(String[] args) {
    Object P6 = new Object();
    Object P10 = new Object();
    CountDownLatch latch = new CountDownLatch(4);

    A03SenderThread T0 = new A03SenderThread(latch, P6, P10, 7, new int[] { 2, 3 });
    A03ReceiverThread T1 = new A03ReceiverThread(latch, P6, 4, new int[] { 3, 5 });
    A03ReceiverThread T2 = new A03ReceiverThread(latch, P10, 5, new int[] { 4, 6 });

    T0.start();
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
