package L04.A02;

public class Main {
  public static void main(String[] args) {
    Object monitor0 = new Object();
    Object P9 = new Object();
    Object P10 = new Object();

    A02Thread T1 = new A02Thread(
        monitor0, P9, P10,
        new int[] { 2, 4 },
        new int[] { 4, 6 },
        new int[] { 0, 4 });

    A02Thread T2 = new A02Thread(
        monitor0, P10, P9,
        new int[] { 3, 5 },
        new int[] { 5, 7 },
        new int[] { 0, 5 });

    T1.start();
    T2.start();
  }
}
