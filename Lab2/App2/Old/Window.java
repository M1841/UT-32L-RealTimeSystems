package Lab2.App2.Old;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Window extends JFrame {
  public void setProgressValue(int barId, int value) {
    bars.get(barId).setValue(value);
  }

  public Window(int threadCount) {
    setLayout(null);
    setSize(450, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    init(threadCount);
    this.setVisible(true);
  }

  private void init(int n) {
    for (int i = 0; i < n; i++) {
      JProgressBar progressBar = new JProgressBar();
      progressBar.setMaximum(1000);
      progressBar.setBounds(50, (i + 1) * 30, 350, 20);
      this.add(progressBar);
      this.bars.add(progressBar);
    }
  }

  private ArrayList<JProgressBar> bars = new ArrayList<JProgressBar>();
}
