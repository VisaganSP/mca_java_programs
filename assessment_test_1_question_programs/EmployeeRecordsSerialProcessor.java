import java.io.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeRecordsSerialProcessor {

    public static void main(String[] args) {
        String inputFilePath = "employee_records.txt";
        String outputFilePath = "serialized_employee_records.dat";

        // Read employee records from the text file
        List<EmployeeSerial> employees = readEmployeeRecords(inputFilePath);

        // Serialize employee objects and write to a binary file
        serializeEmployeeRecords(employees, outputFilePath);

        // Deserialize employee objects from the binary file
        List<EmployeeSerial> deserializedEmployees = deserializeEmployeeRecords(outputFilePath);

        // Print the deserialized employee records
        for (EmployeeSerial employee : deserializedEmployees) {
            System.out.println(employee);
        }
    }

    private static List<EmployeeSerial> readEmployeeRecords(String filePath) {
        List<EmployeeSerial> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int empId = Integer.parseInt(parts[0]);
                String empName = parts[1];
                String empDesignation = parts[2];
                int empSalary = Integer.parseInt(parts[3]);

                EmployeeSerial employee = new EmployeeSerial(empId, empName, empDesignation, empSalary);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    private static void serializeEmployeeRecords(List<EmployeeSerial> employees, String filePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(employees);
            System.out.println("Employee records serialized and saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static List<EmployeeSerial> deserializeEmployeeRecords(String filePath) {
        List<EmployeeSerial> employees = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List) {
                employees = (List<EmployeeSerial>) obj;
                System.out.println("Employee records deserialized from " + filePath);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
