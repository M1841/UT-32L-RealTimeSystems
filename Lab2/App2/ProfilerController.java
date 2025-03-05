package Lab2.App2;

@SuppressWarnings("deprecation")
public class ProfilerController {
  public ProfilerController(ProfilerModel model, ProfilerView view) {
    model.addObserver(view);
  }
}
