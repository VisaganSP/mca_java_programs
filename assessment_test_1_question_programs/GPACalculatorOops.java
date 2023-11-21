
// java program 8.b ii)
import java.util.Scanner;

class GPACalculatorOops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for 5 students
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter marks for 5 subjects (separated by spaces): ");
            int[] marks = new int[5];
            for (int j = 0; j < 5; j++) {
                marks[j] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the newline character
            students[i] = new StudentWithGPA(name, marks);
        }

        // Display results for all students
        for (Student student : students) {
            student.displayResult();
            System.out.println("-------------------------------");
        }

        scanner.close();
    }
}

// Interface to calculate GPA
interface GPA {
    double calculateGPA();
}

// Base class Student
class Student {
    protected String name;
    protected int[] marks;

    // Constructor to initialize name and marks
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    // Display student details and GPA
    public void displayResult() {
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + arrayToString(marks));
        System.out.println("GPA: " + calculateGPA());
    }

    // Override this method in subclasses to calculate GPA based on grading system
    public double calculateGPA() {
        return 0.0; // Default implementation, should be overridden in subclasses
    }

    // Helper method to convert an array to a string
    private String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}

// Derived class to calculate GPA for specific grading system
class StudentWithGPA extends Student implements GPA {
    private static final double[] gradePoints = { 4.0, 3.0, 2.0, 1.0, 0.0 }; // GPA scale for simplicity

    // Constructor
    public StudentWithGPA(String name, int[] marks) {
        super(name, marks);
    }

    // Override method to calculate GPA
    @Override
    public double calculateGPA() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double averageMarks = totalMarks / (double) marks.length;
        return getGradePoint(averageMarks);
    }

    // Helper method to get GPA based on average marks
    private double getGradePoint(double averageMarks) {
        if (averageMarks >= 90) {
            return gradePoints[0];
        } else if (averageMarks >= 80) {
            return gradePoints[1];
        } else if (averageMarks >= 70) {
            return gradePoints[2];
        } else if (averageMarks >= 60) {
            return gradePoints[3];
        } else {
            return gradePoints[4];
        }
    }
}