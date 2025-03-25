package Lab3.Ex02;

class Consumer extends Thread {
  Consumer(Buffer bf) {
    this.bf = bf;
  }

  public void run() {
    while (true) {
      System.out.println("Consumer " + this.getName() +
          " received >> " + bf.get());
    }
  }

  private Buffer bf;
}
