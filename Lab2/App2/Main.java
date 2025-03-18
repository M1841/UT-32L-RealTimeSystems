package Lab2.App2;

public class Main {
  public static void main(String[] args) {
    ProfilerView view = new ProfilerView(threadCount);

    for (int i = 0; i < threadCount; i++) {
      ProfilerModel model = new ProfilerModel(i, processorLoad);
      model.start();

      new ProfilerController(model, view);
    }
  }

  private static final int threadCount = 6;
  private static final int processorLoad = 1000000;
}
