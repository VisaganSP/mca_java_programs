import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Dates{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date in the format MM/dd/yyyy: ");
        String inputDate = sc.nextLine();

        DateFormat inputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat outputDateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.US);

        try {
            Date date = inputDateFormat.parse(inputDate);
            String outputDate = outputDateFormat.format(date);
            System.out.println("Formatted date: " + outputDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format");
        }
    }
}