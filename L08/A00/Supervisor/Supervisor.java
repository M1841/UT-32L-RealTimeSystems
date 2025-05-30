package L08.A00.Supervisor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import L08.A00.IntPlace;
import L08.A00.PlaceHandler;
import L08.A00.Controller.Controller;

public class Supervisor extends Thread {
  public PlaceHandler PH = new PlaceHandler();
  public Controller controller;

  boolean stop = false;

  Supervisor_Transition_ts_1 ts_1;
  Supervisor_Transition_ts_2 ts_2;
  Supervisor_Transition_ts_3 ts_3;

  Scanner in = new Scanner(System.in);

  public void run() {
    PH.AddPlace(new Supervisor_Cl_ps_i1("ps_i1", new Supervisor_Type_ps_i1(0, 0, 0)));
    PH.AddPlace(new Supervisor_Cl_ps_1(
        "ps_1", Collections.synchronizedList(new ArrayList<Supervisor_Type_ps_i1>())));
    PH.AddPlace(new IntPlace("ps_i2", 0));
    PH.AddPlace(new IntPlace("ps_o1", 0));
    PH.AddPlace(new IntPlace("ps_o2", 0));
    PH.AddPlace(new IntPlace("ps_2", 1));
    PH.AddPlace(new IntPlace("ps_3", 1));

    ts_1 = new Supervisor_Transition_ts_1("ts_1", PH, 0);
    ts_2 = new Supervisor_Transition_ts_2("ts_2", PH, 0);
    ts_2.ControllerPH = this.controller.PH;
    ts_3 = new Supervisor_Transition_ts_3("ts_3", PH, 0);

    System.out.println("Supervisor: Input p_i1 value");
    this.PH.GetPlaceByName("ps_i1").Set(
        new Supervisor_Type_ps_i1(in.nextInt(), in.nextInt(), in.nextInt()));

    while (!stop) {
      ts_1.TransitionGuardsMappings();
      ts_2.TransitionGuardsMappings();
      ts_3.TransitionGuardsMappings();

      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  public void StopThread() {
    this.stop = true;
  }
}
