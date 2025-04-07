package L04.A03;

public class Main {
  public static void main(String[] args) {
    Object P8 = new Object();

    A03Thread T1 = new A03Thread(
        P8, new int[] { 4, 7 }, new int[] { 0, 3 });

    A03Thread T2 = new A03Thread(
        P8, new int[] { 5, 7 }, new int[] { 0, 6 });

    A03Thread T3 = new A03Thread(
        P8, new int[] { 3, 6 }, new int[] { 0, 5 });

    T1.start();
    T2.start();
    T3.start();
  }
}
