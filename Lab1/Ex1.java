import java.util.Scanner;

public class Ex1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter two numbers");

    System.out.print("a = ");
    int a = scanner.nextInt();

    System.out.print("b = ");
    int b = scanner.nextInt();

    System.out.print("Choose an operation (+, -, * or /): ");
    char op = scanner.next().charAt(0);

    switch (op) {
      case '+' -> {
        System.out.println(a + b);
      }
      case '-' -> {
        System.out.println(a - b);
      }
      case '*' -> {
        System.out.println(a * b);
      }
      case '/' -> {
        if (b == 0) {
          System.out.println("Cannot divide by 0");
          break;
        }
        System.out.println(a / b);
      }
    }

    scanner.close();
  }
}
