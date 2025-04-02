package L04.A04;

public class A04MainThread extends A04Thread {
  public A04MainThread(
      Object monitor1, Object monitor2, int[] delays, int[] delays0) {
    this.monitor1 = monitor1;
    this.monitor2 = monitor2;
    this.delays = delays;
    this.delays0 = delays0;
  }

  public void run() {
    try {
      System.out.println(this.getName() + " - STATE 1");
      Thread.sleep(this.randomDelay(delays0));

      System.out.println(this.getName() + " - STATE 2");
      this.doAction();

      synchronized (this.monitor1) {
        this.monitor1.notify();
        synchronized (this.monitor2) {
          this.monitor2.notify();
        }
      }
      System.out.println(this.getName() + " - STATE 3");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private Object monitor1;
  private Object monitor2;
  private int[] delays0;
}
