package L07.A02;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static void main(String[] args) {
    CyclicBarrier barrier = new CyclicBarrier(4);
    ReentrantLock P9 = new ReentrantLock();
    ReentrantLock P10 = new ReentrantLock();

    while (true) {
      A02SideThread T1 = new A02SideThread(
          barrier, P9,
          new int[] { 2, 4 }, 4);
      A02MidThread T2 = new A02MidThread(
          barrier, P9, P10,
          new int[] { 3, 6 }, 3);
      A02SideThread T3 = new A02SideThread(
          barrier, P10,
          new int[] { 2, 5 }, 5);

      T1.start();
      T2.start();
      T3.start();

      try {
        barrier.await();
        barrier.reset();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}
