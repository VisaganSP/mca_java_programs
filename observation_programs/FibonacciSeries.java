import java.util.Scanner;

public class FibonacciSeries {
    static void fibonacci(int N) {
        int num1 = 0, num2 = 1;

        int counter = 0;

        // Iterate till counter is N
        System.out.print("Fibbonacci Series is: ");
        while (counter < N) {

            // Print the number
            System.out.print(num1 + " ");

            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
    }

    public static void main(String[] args) {
        int number;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number to find fibonnaci: ");
        number = in.nextInt();

        fibonacci(number);

        in.close();
    }
}