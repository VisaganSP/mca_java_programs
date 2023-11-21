import java.util.Scanner;

public class PhoneNo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phone number of the format (555)555-5555");
        String phoneno = scanner.nextLine();
        String[] tokens = phoneno.split("[()\\-]");
        String areaCode = tokens[1];
        String first3Digits = tokens[2];
        String last4Digits = tokens[3];
        System.out.println("Area Code: " + areaCode);
        System.out.println("Phone Number: " + first3Digits + last4Digits);
        System.out.println("Area Code with Phone Number: " + areaCode + first3Digits + last4Digits);
        scanner.close();
    }
}