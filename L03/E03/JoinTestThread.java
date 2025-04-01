package L03.E03;

class JoinTestThread extends Thread {
  Thread thread;
  int num;

  JoinTestThread(String name, Thread thread, int num) {
    this.setName(name);
    this.thread = thread;
    this.num = num;
  }

  public void run() {
    System.out.println("Thread " + getName() + " has entered the run() method");
    try {
      if (thread != null)
        thread.join();

      System.out.println("Thread " + getName() + " executing operation.");
      computeSum();

      System.out.println("Thread " + getName() + " has terminated operation. Sum = " + Main.Sum);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void computeSum() {
    int sum = 0;
    for (int i = 1; i * i <= num; i++) {
      if (num % i == 0) {
        sum += i + num / i;
      }
    }
    Main.Sum = sum;
  }
}
