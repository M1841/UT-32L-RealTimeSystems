package L08.A00;

import L08.A00.Supervisor.Supervisor;
import L08.A00.Controller.Controller;
import L08.A00.Robot.Robot;

public class Main {
  public static void main(String[] args) {
    Supervisor supervisor = new Supervisor();
    Controller controller = new Controller();
    Robot robot = new Robot();

    supervisor.controller = controller;

    controller.supervisor = supervisor;
    controller.robot = robot;

    robot.controller = controller;

    supervisor.start();
    controller.start();
    robot.start();
  }
}
