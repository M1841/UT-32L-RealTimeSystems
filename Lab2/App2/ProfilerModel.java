package Lab2.App2;

import java.util.Observable;

public class ProfilerModel extends Observable implements Runnable {
  public void run() {
    for (int c = 0; c < 1000; c++) {
      for (int j = 0; j < processorLoad; j++) {
        j++;
        for (int i = 0; i < processorLoad; i++) {
          i++;
          i--;
        }
        j--;
      }
      progress = c + 1;
      this.setChanged();
      this.notifyObservers();
    }
  }

  public void start() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  public ProfilerModel(int id, int processorLoad) {
    this.id = id;
    this.processorLoad = processorLoad;
  }

  public int getId() {
    return id;
  }

  public int getProgress() {
    return progress;
  }

  private Thread thread;
  private int id;
  private int progress;
  private int processorLoad;
}
