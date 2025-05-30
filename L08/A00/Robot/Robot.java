package L08.A00.Robot;

import L08.A00.*;
import L08.A00.Controller.*;

public class Robot extends Thread {

  boolean stop = false;
  public PlaceHandler PH = new PlaceHandler();

  public Controller controller;

  Robot_Transition_t_1 t_1;
  Robot_Transition_t_2 t_2;

  public void run() {

    PH.AddPlace(new IntPlace("p_0", 0));
    PH.AddPlace(new IntPlace("p_1", null));
    PH.AddPlace(new IntPlace("p_i", null));
    PH.AddPlace(new IntPlace("p_o", null));
    t_1 = new Robot_Transition_t_1("t_1", PH, 0);
    t_2 = new Robot_Transition_t_2("t_2", PH, 5);
    t_2.ControllerPH = controller.PH;// this transition has an output channel connected to the controller

    while (!stop) {
      t_1.TransitionGuardsMappings();

      t_2.TransitionGuardsMappings();

      // For slower printing on the console
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  public void StopThread() {
    this.stop = true;
  }

}
