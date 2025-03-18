package Lab2.App2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

@SuppressWarnings("deprecation")
public class ProfilerView extends JFrame implements Observer {
  public ProfilerView(int threadCount) {
    setLayout(null);
    setSize(530, 330);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    init(threadCount);

    this.setVisible(true);
  }

  public void update(Observable observable, Object arg) {
    ProfilerModel model = (ProfilerModel) observable;

    int id = model.getId();
    int progress = model.getProgress();

    bars.get(id).setValue(progress);
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
