package L08.A00.Supervisor;

import L08.A00.Interfaces.PlaceHandlerTemplate;
import L08.A00.Interfaces.TransitionTemplate;

public class Supervisor_Transition_ts_3 implements TransitionTemplate {
  String Name;
  PlaceHandlerTemplate PH;
  Integer EET, LET, timeUnitControl = 500;

  public Supervisor_Transition_ts_3(String name, PlaceHandlerTemplate PH, Integer delay) {
    this.Init(name, PH);
    this.SetDelay(delay);
  }

  public Supervisor_Transition_ts_3(String name, PlaceHandlerTemplate PH, Integer EET, Integer LET) {
    this.Init(name, PH);
    this.SetDelayInRange(EET, LET);
  }

  @Override
  public void Init(String Name, PlaceHandlerTemplate PH) {
    this.Name = Name;
    this.PH = PH;
  }

  @Override
  public void SetDelay(int value) {
    this.EET = value;
  }

  @Override
  public void SetDelayInRange(int eet, int let) {
    this.EET = eet;
    this.LET = let;
  }

  @Override
  public void TransitionDelay() {
    try {
      if (this.LET == null) {
        Thread.sleep(this.EET * timeUnitControl);
      } else {
        Thread.sleep(Math.round(
            Math.random() * (this.LET - this.EET) + this.EET) * timeUnitControl);
      }
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public Boolean TransitionGuardsMappings() {
    this.TransitionDelay();
    String toPrint = "--------------Supervisor--------------\n";

    if (!PH.GetPlaceByName("ps_i2").IsNull()) {
      PH.GetPlaceByName("ps_2").Set(PH.GetPlaceByName("ps_i2").Get());
      PH.GetPlaceByName("ps_o2").Set(PH.GetPlaceByName("ps_i2").Get());
      PH.GetPlaceByName("ps_i2").Set(null);

      toPrint = toPrint.concat(this.Print() + "\n");
      toPrint = toPrint.concat("--------------------------------------\n");
      System.out.println(toPrint);

      return true;
    }
    return false;
  }

  @Override
  public String Print() {
    return this.Name + "\n" + this.PH.PrintAllPlaces();
  }
}
