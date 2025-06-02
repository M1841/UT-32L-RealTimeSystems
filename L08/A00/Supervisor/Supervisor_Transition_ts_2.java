package L08.A00.Supervisor;

import java.util.List;

import L08.A00.Interfaces.PlaceHandlerTemplate;
import L08.A00.Interfaces.TransitionTemplate;

public class Supervisor_Transition_ts_2 implements TransitionTemplate {
  String Name;
  Integer EET, LET, timeUnitControl = 500;
  PlaceHandlerTemplate PH, ControllerPH;

  public Supervisor_Transition_ts_2(String name, PlaceHandlerTemplate PH, Integer delay) {
    this.Init(name, PH);
    this.SetDelay(delay);
  }

  public Supervisor_Transition_ts_2(String name, PlaceHandlerTemplate PH, Integer EET, Integer LET) {
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

  @SuppressWarnings("unchecked")
  @Override
  public Boolean TransitionGuardsMappings() {
    this.TransitionDelay();
    String toPrint = "--------------Supervisor--------------\n";

    if (!PH.GetPlaceByName("ps_1").IsNull()
        && !PH.GetPlaceByName("ps_2").IsNull()
        && ((List<Supervisor_Type_ps_i1>) PH.GetPlaceByName("ps_1").Get()).getLast()
            .R() != PH.GetPlaceByName("ps_2").Get()) {
      PH.GetPlaceByName("ps_o1").Set(
          ((List<Supervisor_Type_ps_i1>) PH.GetPlaceByName("ps_1").Get()).getLast().R());
      PH.GetPlaceByName("ps_3").Set(
          ((List<Supervisor_Type_ps_i1>) PH.GetPlaceByName("ps_1").Get()).getLast().E());
      this.SetDelay((Integer) PH.GetPlaceByName("ps_3").Get());

      ControllerPH.GetPlaceByName("p_i1").Set(PH.GetPlaceByName("ps_o1").Get());
      PH.GetPlaceByName("ps_2").Set(null);

      toPrint = toPrint.concat(this.Print() + "\n");
      toPrint = toPrint.concat("ControllerPH\n" + ControllerPH.PrintAllPlaces() + "\n");
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
