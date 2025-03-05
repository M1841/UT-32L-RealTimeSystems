package Lab2.App2;

public class ProfilerController {
  public ProfilerController(ProfilerModel model, ProfilerView view) {
    model.addObserver(view);
    this.model = model;
    this.view = view;
  }

  private ProfilerModel model;
  private ProfilerView view;
}
