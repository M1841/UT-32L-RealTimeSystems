package L04.A04;

public abstract class A04Thread extends Thread {
  protected void doAction() {
    for (int i = 0; i < this.randomDelay(this.delays) * 100_000; i++) {
      i++;
      i--;
    }
  }

  protected int randomDelay(int[] range) {
    return (int) Math.round(
        Math.random() * (range[1] - range[0]) + range[0]) * 500;
  }

  protected int[] delays;
}
