package L04.A01;

public class A01SideThread extends A01Thread {
  public A01SideThread(
      Object monitor,
      int[] actionDelays, int transitionDelay) {
    this.monitor = monitor;
    this.actionDelays = actionDelays;
    this.transitionDelay = transitionDelay;
  }

  public void run() {
    try {
      System.out.println(this.getName() + " - STATE 1");

      synchronized (this.monitor) {
        System.out.println(this.getName() + " - STATE 2");
        this.doAction();

        Thread.sleep(this.transitionDelay);
      }
      System.out.println(this.getName() + " - STATE 3");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private Object monitor;
}
