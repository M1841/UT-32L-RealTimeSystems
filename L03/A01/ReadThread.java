package L03.A01;

public class ReadThread extends Thread {
  public ReadThread(FileService service) {
    this.service = service;
  }

  public void run() {
    while (!Main.isStopThreads()) {
      try {
        synchronized (service) {
          String readMsg = service.read();
          System.out.println(readMsg);
        }

        Thread.sleep(3000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  FileService service;
}
