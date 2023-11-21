import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

class ReadSurveyResponses {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("numbers.txt"));
                PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {

            System.out.println("Survey responses:");

            while (scanner.hasNextInt()) {
                int response = scanner.nextInt();
                System.out.println(response);
                writer.println(response);
            }

            System.out.println("Survey responses written to output.txt.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
