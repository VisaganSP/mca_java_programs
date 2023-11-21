import java.util.Scanner;

public class PalindromeOrNot {
    public static boolean isPalindrome(String str) {
        // Initializing an empty string to store the reverse
        // of the original str
        String rev = "";

        // Initializing a new boolean variable for the
        // answer
        boolean ans = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        // Checking if both the strings are equal
        if (str.equals(rev)) {
            ans = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        String stringToCheck;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the string to find whether it's palindrome or not: ");
        stringToCheck = in.nextLine();

        if (isPalindrome(stringToCheck))
            System.out.println("The given " + stringToCheck + " is a palindrome string.");
        else
            System.out.println("The given " + stringToCheck + " is not an palindrome string.");

        in.close();
    }
}
