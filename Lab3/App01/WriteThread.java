package Lab3.App01;

public class WriteThread extends Thread {
  public WriteThread(FileService service) {
    this.service = service;
  }

  public void run() {
    while (!Main.isStopThreads()) {
      synchronized (service) {
        String msg = String.valueOf(Math.round(Math.random() * 100));
        service.write(msg);
      }

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  FileService service;
}
