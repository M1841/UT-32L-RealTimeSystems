package L08.A00.Controller;

import L08.A00.Interfaces.*;

public class Controller_Transition_t_2 implements TransitionTemplate {
  Integer timeUnitControl = 500;
  Integer eet;
  Integer let;
  String Name;
  PlaceHandlerTemplate PH, SupervisorPH;

  public Controller_Transition_t_2(String name, PlaceHandlerTemplate PH, Integer delay) {
    this.Init(name, PH);
    this.SetDelay(delay);
  }

  public Controller_Transition_t_2(String name, PlaceHandlerTemplate PH, Integer eet, Integer let) {
    this.Init(name, PH);
    this.SetDelayInRange(eet, let);
  }

  @Override
  public void TransitionDelay() {
    try {
      if (this.let == null) {
        Thread.sleep(this.eet * timeUnitControl);
      } else {
        Thread.sleep(Math.round(Math.random() * (this.let - this.eet) + this.eet) * timeUnitControl);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Boolean TransitionGuardsMappings() {
    TransitionDelay();
    String toPrint = "--------------Controller--------------\n";
    if ((!PH.GetPlaceByName("p_i2").IsNull()) & !PH.GetPlaceByName("p_2").IsNull()) {
      toPrint = toPrint.concat(Print() + "\n");

      PH.GetPlaceByName("p_1").Set(PH.GetPlaceByName("p_i2").Get());
      PH.GetPlaceByName("p_o1").Set(PH.GetPlaceByName("p_i2").Get());
      PH.GetPlaceByName("p_i2").Set(null);
      PH.GetPlaceByName("p_2").Set(null);

      SupervisorPH.GetPlaceByName("ps_i2").Set(PH.GetPlaceByName("p_o1").Get());

      toPrint = toPrint.concat(Print() + "\n");
      toPrint = toPrint.concat("SupervisorPH\n" + SupervisorPH.PrintAllPlaces() + "\n");
      toPrint = toPrint.concat("--------------------------------------\n");
      System.out.println(toPrint);
      return true;
    }
    return false;
  }

  @Override
  public void Init(String name, PlaceHandlerTemplate PH) {
    this.PH = PH;
    this.Name = name;
  }

  @Override
  public void SetDelay(int value) {
    this.eet = value;
  }

  @Override
  public void SetDelayInRange(int eet, int let) {
    this.eet = eet;
    this.let = let;
  }

  @Override
  public String Print() {
    return this.Name + "\n" + this.PH.PrintAllPlaces();
  }
}
