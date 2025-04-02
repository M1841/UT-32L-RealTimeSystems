package L04.A01;

public abstract class A01Thread extends Thread {
  protected void doAction() {
    for (int i = 0; i < this.randomDelay(this.actionDelays) * 100_000; i++) {
      i++;
      i--;
    }
  }

  protected int randomDelay(int uppedBound) {
    return this.randomDelay(new int[] { 0, uppedBound });
  }

  protected int randomDelay(int[] range) {
    return (int) Math.round(
        Math.random() * (range[1] - range[0]) + range[0]) * 500;
  }

  protected int[] actionDelays;
  protected int transitionDelay;
}
