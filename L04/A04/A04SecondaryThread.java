package L04.A04;

public class A04SecondaryThread extends A04Thread {
  public A04SecondaryThread(Object monitor, int[] delays,
      A04MainThread mainThread) {
    this.monitor = monitor;
    this.delays = delays;
    this.mainThread = mainThread;
  }

  public void run() {
    try {
      System.out.println(this.getName() + " - STATE 1");
      synchronized (this.monitor) {
        this.monitor.wait();

        System.out.println(this.getName() + " - STATE 2");
        this.doAction();

        System.out.println(this.getName() + " - STATE 3");
        mainThread.join();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private Object monitor;
  private A04MainThread mainThread;
}
