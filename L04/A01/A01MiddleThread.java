package L04.A01;

public class A01MiddleThread extends A01Thread {
  public A01MiddleThread(
      Object monitor1, Object monitor2,
      int[] actionDelays, int transitionDelay) {
    this.monitor1 = monitor1;
    this.monitor2 = monitor2;
    this.actionDelays = actionDelays;
    this.transitionDelay = transitionDelay;
  }

  public void run() {
    try {
      System.out.println(this.getName() + " - STATE 1");

      synchronized (this.monitor1) {
        synchronized (this.monitor2) {
          System.out.println(this.getName() + " - STATE 2");
          this.doAction();

          Thread.sleep(this.transitionDelay);
        }
      }
      System.out.println(this.getName() + " - STATE 3");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private Object monitor1;
  private Object monitor2;
}
