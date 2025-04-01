package L02;

@SuppressWarnings("deprecation")
public class ProfilerController {
  public ProfilerController(ProfilerModel model, ProfilerView view) {
    model.addObserver(view);
  }
}
