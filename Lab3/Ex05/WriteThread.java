package Lab3.Ex05;

import java.io.PipedOutputStream;

class WriteThread extends Thread {
  WriteThread() {
    po = new PipedOutputStream();
  }

  public void run() {
    try {
      while (true) {
        int d = (int) (10 * Math.random());
        System.out.println("Writing Thread is sent : " + d);
        po.write(d);
        sleep(400);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  PipedOutputStream getPipe() {
    return po;
  }

  private PipedOutputStream po;
}
