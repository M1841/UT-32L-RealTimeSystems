package L07.A04;

import java.util.concurrent.Semaphore;

public class Main {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(2);

    L07A04Thread T0 = new L07A04Thread(
        semaphore,
        new int[] { 4, 7 }, 3);

    L07A04Thread T1 = new L07A04Thread(
        semaphore,
        new int[] { 5, 7 }, 6);

    L07A04Thread T2 = new L07A04Thread(
        semaphore,
        new int[] { 3, 6 }, 5);

    T0.start();
    T1.start();
    T2.start();
  }
}
