package Lab2.App2.Old;

public class Task extends Thread {
  public void run() {
    for (int c = 0; c < 1000; c++) {
      for (int j = 0; j < processorLoad; j++) {
        j++;
        j--;
      }
      window.setProgressValue(id, c + 1);
    }
  }

  public Task(int id, int priority, Window window, int processorLoad) {
    this.id = id;
    this.window = window;
    this.processorLoad = processorLoad;
    this.setPriority(priority);
  }

  private int id;
  private Window window;
  private int processorLoad;
}
