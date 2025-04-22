package L04.A02_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
  public static void main(String[] args) {
    Lock P9 = new ReentrantLock();
    Lock P10 = new ReentrantLock();

    A02Thread T1 = new A02Thread(
        P9, P10,
        new int[] { 2, 4 },
        new int[] { 4, 6 },
        new int[] { 0, 4 });

    A02Thread T2 = new A02Thread(
        P10, P9,
        new int[] { 3, 5 },
        new int[] { 5, 7 },
        new int[] { 0, 5 });

    T1.start();
    T2.start();
  }
}
