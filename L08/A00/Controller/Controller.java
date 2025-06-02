package L08.A00.Controller;

import java.util.Scanner;

import L08.A00.*;
import L08.A00.Robot.*;
import L08.A00.Supervisor.Supervisor;

public class Controller extends Thread {
  boolean stop = false;
  public Robot robot;
  public Supervisor supervisor;
  public PlaceHandler PH = new PlaceHandler();

  Controller_Transition_t_1 t_1;
  Controller_Transition_t_2 t_2;
  Controller_Transition_t_o2 t_o2;
  Scanner in = new Scanner(System.in);

  public void run() {
    PH.AddPlace(new IntPlace("p_i1", null));
    PH.AddPlace(new IntPlace("p_1", 1));
    PH.AddPlace(new IntPlace("p_o1", null));
    PH.AddPlace(new IntPlace("p_2", null));
    PH.AddPlace(new IntPlace("p_i2", null));

    t_1 = new Controller_Transition_t_1("t_1", PH, 0);
    t_2 = new Controller_Transition_t_2("t_2", PH, 0);
    t_2.SupervisorPH = this.supervisor.PH;
    t_o2 = new Controller_Transition_t_o2("t_o2", PH, 0);
    t_o2.RobotPH = robot.PH;// this transition has an output channel connected to the robot

    while (!stop) {
      t_1.TransitionGuardsMappings();
      t_2.TransitionGuardsMappings();
      t_o2.TransitionGuardsMappings();

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
