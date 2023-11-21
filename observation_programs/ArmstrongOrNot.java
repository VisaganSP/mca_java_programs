package observation_programs;

import java.util.Scanner;

public class ArmstrongOrNot {

    static boolean armstrong(int n) {
        int temp = n;
        int p = 0;

        // Function to calculate the sum of
        // individual digits
        while (n > 0) {
            int rem = n % 10;
            p = (p) + (rem * rem * rem);
            n = n / 10;
        }

        // Condition to check whether the value
        // of P equals to user input or not.
        if (temp == p)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int number;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number to find whether it's armstrong or not: ");
        number = in.nextInt();

        if (armstrong(number))
            System.out.println("The given " + number + " is an armstrong number.");
        else
            System.out.println("The given " + number + " is not an armstrong number.");

        in.close();
    }
}
