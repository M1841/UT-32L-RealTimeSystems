package L08.A00.Supervisor;

import L08.A00.Interfaces.PlaceHandlerTemplate;
import L08.A00.Interfaces.TransitionTemplate;

public class Supervisor_Transition_ts_2 implements TransitionTemplate {
  @Override
  public void Init(String Name, PlaceHandlerTemplate PH) {
    throw new UnsupportedOperationException("Unimplemented method 'Init'");
  }

  @Override
  public void SetDelay(int value) {
    throw new UnsupportedOperationException("Unimplemented method 'SetDelay'");
  }

  @Override
  public void SetDelayInRange(int eet, int let) {
    throw new UnsupportedOperationException("Unimplemented method 'SetDelayInRange'");
  }

  @Override
  public void TransitionDelay() {
    throw new UnsupportedOperationException("Unimplemented method 'TransitionDelay'");
  }

  @Override
  public Boolean TransitionGuardsMappings() {
    throw new UnsupportedOperationException("Unimplemented method 'TransitionGuardsMappings'");
  }

  @Override
  public String Print() {
    throw new UnsupportedOperationException("Unimplemented method 'Print'");
  }
}
