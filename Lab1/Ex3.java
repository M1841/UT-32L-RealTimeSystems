public class Ex3 {
  public static void main(String[] args) {
    int[] arr = new int[10];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
      num = (int) ((Math.random() - 0.5) * 2 * 1000);

      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }

    System.out.println("Max: " + max);
    System.out.println("Min: " + min);
  }
}
