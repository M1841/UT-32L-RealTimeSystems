package L04.A01;

public class Main {
  public static void main(String[] args) {
    Object P9 = new Object();
    Object P10 = new Object();

    A01SideThread T0 = new A01SideThread(P9, new int[] { 2, 4 }, 4);
    A01MiddleThread T1 = new A01MiddleThread(P9, P10, new int[] { 3, 6 }, 3);
    A01SideThread T2 = new A01SideThread(P10, new int[] { 2, 5 }, 5);

    T0.start();
    T1.start();
    T2.start();
  }
}
