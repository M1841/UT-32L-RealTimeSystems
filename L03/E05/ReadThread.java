package L03.E05;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class ReadThread extends Thread {
  ReadThread() {
    pi = new PipedInputStream();
  }

  public void run() {
    try {
      while (true) {
        if (pi.available() > 0) {
          System.out.println("Read Thread is received: " + pi.read());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  void connect(PipedOutputStream os) throws Exception {
    pi.connect(os);
  }

  private PipedInputStream pi;
}
