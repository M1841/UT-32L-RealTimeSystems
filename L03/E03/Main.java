package L03.E03;

public class Main {
  public static void main(String[] args) {
    JoinTestThread thread1 = new JoinTestThread("Thread 1", null, 50_001);
    JoinTestThread thread2 = new JoinTestThread("Thread 2", thread1, 20_001);
    thread1.start();
    thread2.start();
  }

  public static int Sum = 0;
}
