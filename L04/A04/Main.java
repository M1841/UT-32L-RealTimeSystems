package L04.A04;

public class Main {
  public static void main(String[] args) {
    Object P6 = new Object();
    Object P10 = new Object();

    A04MainThread mainThread = new A04MainThread(
        P6, P10,
        new int[] { 2, 3 }, new int[] { 0, 7 });

    A04SecondaryThread secondaryThread1 = new A04SecondaryThread(
        P6, new int[] { 3, 5 }, mainThread);

    A04SecondaryThread secondaryThread2 = new A04SecondaryThread(
        P10, new int[] { 4, 6 }, mainThread);

    mainThread.start();
    secondaryThread1.start();
    secondaryThread2.start();
  }
}
