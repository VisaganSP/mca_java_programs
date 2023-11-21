import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateFormatConvertor {

    public static void main(String[] args) {
        // Create a SimpleDateFormat object for parsing and formatting
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat outputFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);

        // Get input date from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date in the format DD/MM/YYYY: ");
        String inputDateStr = scanner.nextLine();

        try {
            // Parse the input date string
            Date inputDate = inputFormat.parse(inputDateStr);

            // Format the date in the desired output format
            String outputDateStr = outputFormat.format(inputDate);

            // Print the converted date
            System.out.println("The converted date is: " + outputDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format DD/MM/YYYY.");
        } finally {
            scanner.close();
        }
    }
}