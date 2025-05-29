package L08.A00;

import L08.A00.Controller.Controller;
import L08.A00.Robot.Robot;

public class Main {
  public static void main(String[] args) {
    Controller c = new Controller();
    Robot r = new Robot();
    c.r = r;
    r.c = c;
    c.start();
    r.start();
  }
}
