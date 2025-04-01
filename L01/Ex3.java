public class Ex3 {
  public static void main(String[] args) {
    int[] arr = new int[10];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) ((Math.random() - 0.5) * 2 * 1000);
    }

    int min = arr[0];
    int max = arr[0];

    for (int num : arr) {
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
