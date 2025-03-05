public class Ex2 {
  public static void main(String[] args) {
    int[][] mat1 = new int[][] {
        new int[] { 2, 3, 1 },
        new int[] { 7, 1, 6 },
        new int[] { 9, 2, 4 }
    };
    int[][] mat2 = new int[][] {
        new int[] { 8, 5, 3 },
        new int[] { 3, 9, 2 },
        new int[] { 2, 7, 3 }
    };

    int[][] sum = new int[3][3];
    int[][] difference = new int[3][3];
    int[][] product = new int[][] {
        new int[] { 0, 0, 0 },
        new int[] { 0, 0, 0 },
        new int[] { 0, 0, 0 }
    };

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        sum[i][j] = mat1[i][j] + mat2[i][j];
        difference[i][j] = mat1[i][j] - mat2[i][j];

        for (int k = 0; k < 3; k++) {
          product[i][j] += mat1[i][k] * mat2[k][j];
        }
      }
    }

    System.out.println("Sum:");
    printMatrix(sum);
    System.out.println("\nDifference:");
    printMatrix(difference);
    System.out.println("\nProduct:");
    printMatrix(product);
  }

  private static void printMatrix(int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }
}
