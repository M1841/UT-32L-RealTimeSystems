package L03.E04;

class ThreadEx extends Thread {
  ThreadEx(ThreadGroup tg, String name) {
    super(tg, name);
    stop = false;
  }

  public void run() {
    System.out.println(Thread.currentThread().getName() + " ON.");

    try {
      for (int i = 1; i < 1000; i++) {
        System.out.print(".");
        Thread.sleep(250);

        synchronized (this) {
          if (stop)
            break;
        }
      }
    } catch (Exception exc) {
      System.out.println(Thread.currentThread().getName() + " intrerupt.");
    }

    System.out.println(Thread.currentThread().getName() + " The end.");
  }

  public void stopThread() {
    stop = true;
  }

  boolean stop;
}
