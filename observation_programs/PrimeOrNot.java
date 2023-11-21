import java.util.Scanner;

class PrimeOrNot {
    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    // Driver Program
    public static void main(String args[]) {
        int number;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number to find whether it's prime or not: ");
        number = in.nextInt();

        if (isPrime(number))
            System.out.println("The given " + number + " is a prime number.");
        else
            System.out.println("The given " + number + " is not a prime number.");

        in.close();
    }
}