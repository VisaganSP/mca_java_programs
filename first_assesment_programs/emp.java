import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void updateSalaryByPercentage(double percentage) {
        if (percentage > 0) {
            salary += salary * (percentage / 100);
        }
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + "\nName: " + name + "\nSalary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Salary");
            System.out.println("3. View Employee Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee salary: $");
                    double salary = scanner.nextDouble();

                    Employee employee = new Employee(id, name, salary);
                    employees.add(employee);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter employee ID for salary update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter salary update percentage: ");
                    double percentage = scanner.nextDouble();

                    for (Employee emp : employees) {
                        if (emp.getId() == updateId) {
                            emp.updateSalaryByPercentage(percentage);
                            System.out.println("Salary updated successfully.");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter employee ID to view details: ");
                    int viewId = scanner.nextInt();

                    for (Employee emp : employees) {
                        if (emp.getId() == viewId) {
                            System.out.println(emp);
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Employee Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
