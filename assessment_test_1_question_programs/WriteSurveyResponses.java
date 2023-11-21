import java.util.Formatter;
import java.util.Scanner;

class WriteSurveyResponses {

    public static void main(String[] args) {
        try (Formatter formatter = new Formatter("numbers.txt");
                Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter survey responses (enter -1 to finish):");

            int response;
            while ((response = scanner.nextInt()) != -1) {
                formatter.format("%d%n", response);
            }

            System.out.println("Survey responses written to numbers.txt.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
