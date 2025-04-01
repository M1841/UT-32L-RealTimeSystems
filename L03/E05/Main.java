package L03.E05;

public class Main {
  public static void main(String args[]) {
    ReadThread rt = new ReadThread();
    WriteThread wt = new WriteThread();

    try {
      rt.connect(wt.getPipe());
      rt.start();
      wt.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
