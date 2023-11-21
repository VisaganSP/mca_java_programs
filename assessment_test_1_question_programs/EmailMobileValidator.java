import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMobileValidator {
    public static void main(String[] args) {
        String email = "user@example.com";
        String mobileNumber = "1234567890";

        if (isValidEmail(email)) {
            System.out.println("Email is valid: " + email);
        } else {
            System.out.println("Email is invalid: " + email);
        }

        if (isValidMobileNumber(mobileNumber)) {
            System.out.println("Mobile number is valid: " + mobileNumber);
        } else {
            System.out.println("Mobile number is invalid: " + mobileNumber);
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Method to validate mobile number using regular expression
    private static boolean isValidMobileNumber(String mobileNumber) {
        // Assuming a 10-digit mobile number for simplicity
        String mobileRegex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(mobileRegex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }
}