import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManipulation{

    public static void main(String[] args) {
        String fileName = "example.txt";

        // Write to a file
        writeToFile(fileName, "Hello, this is a file manipulation example.\n");

        // Read from a file
        String content = readFromFile(fileName);
        System.out.println("File Content:\n" + content);
    }

    private static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Write to file successful.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        return content.toString();
    }
}
