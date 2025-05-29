package L08.A00.Supervisor;

import L08.A00.IntPlace;
import L08.A00.PlaceHandler;

public class Supervisor extends Thread {
  public PlaceHandler PH = new PlaceHandler();

  Supervisor_Transition_ts_1 ts_1;
  Supervisor_Transition_ts_2 ts_2;
  Supervisor_Transition_ts_3 ts_3;

  public void run() {
    PH.AddPlace(new Supervisor_Cl_ps_i1("ps_i1", new Supervisor_Type_ps_i1(0, 0, 0)));
    PH.AddPlace(new IntPlace("ps_i2", 0));
    PH.AddPlace(new IntPlace("ps_o1", 0));
    PH.AddPlace(new IntPlace("ps_o2", 0));
    PH.AddPlace(new IntPlace("ps_1", 0));
    PH.AddPlace(new IntPlace("ps_2", 1));
    PH.AddPlace(new IntPlace("ps_3", 1));

    ts_1 = new Supervisor_Transition_ts_1("ts_1", PH, 0);
    ts_2 = new Supervisor_Transition_ts_2();
    ts_3 = new Supervisor_Transition_ts_3();
  }
}
