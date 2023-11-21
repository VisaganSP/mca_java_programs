import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveEmployeeDetailsToFile {

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_records.txt", true));
                Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter employee details (Enter 'exit' to finish):");

            while (true) {
                System.out.print("Employee ID: ");
                String empId = scanner.nextLine();
                if (empId.equalsIgnoreCase("exit")) {
                    break;
                }

                System.out.print("Employee Name: ");
                String empName = scanner.nextLine();

                System.out.print("Employee Designation: ");
                String empDesignation = scanner.nextLine();

                System.out.print("Employee Salary: ");
                String empSalary = scanner.nextLine();

                // Write employee details to the file
                writer.write(empId + " " + empName + " " + empDesignation + " " + empSalary);
                writer.newLine();
            }

            System.out.println("Employee details saved to employee_records.txt.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
