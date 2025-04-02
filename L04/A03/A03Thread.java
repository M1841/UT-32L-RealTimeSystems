package L04.A03;

public class A03Thread extends Thread {
  public A03Thread(Object monitor, int[] delays1, int[] delays2) {
    this.monitor = monitor;
    this.delays1 = delays1;
    this.delays2 = delays2;
  }

  public void run() {
    try {
      while (true) {
        System.out.println(this.getName() + " - STATE 1");

        synchronized (this.monitor) {
          System.out.println(this.getName() + " - STATE 2");
          int j = this.randomDelay(delays1[0], delays1[0]);
          for (int i = 0; i < j * 100_000; i++) {
            i++;
            i--;
          }
        }

        System.out.println(this.getName() + " - STATE 3");
        Thread.sleep(this.randomDelay(delays2[0], delays2[1]));

        System.out.println(this.getName() + " - STATE 4");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private int randomDelay(int lowerBound, int upperBound) {
    return (int) Math.round(
        Math.random() * (upperBound - lowerBound) + lowerBound) * 500;
  }

  private Object monitor;
  private int[] delays1;
  private int[] delays2;
}
