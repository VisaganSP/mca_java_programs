import java.util.Scanner;

interface GradeCalculator {
    double calculateGrade(String grade);
}

class GPA implements GradeCalculator {
    public double calculateGrade(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1.0;
            default:
                return 0.0;
        }
    }
}

class Student1{
    private String name;
    private String subject1;
    private String subject2;
    private String subject3;
    private String subject4;
    private String subject5;
    private double GPA;

    public Student1(String name, String subject1, String subject2, String subject3, String subject4, String subject5) {
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;
        this.GPA = 0.0;
    }

    public void calculateGPA(GradeCalculator calculator) {
        double totalGradePoints = calculator.calculateGrade(subject1) + calculator.calculateGrade(subject2) +
                calculator.calculateGrade(subject3) + calculator.calculateGrade(subject4) + calculator.calculateGrade(subject5);
        double totalCredits = 5.0;
        this.GPA = totalGradePoints / totalCredits;
    }

    public void printResult() {
        System.out.println("Name: " + this.name);
        System.out.println("Subject 1: " + this.subject1);
        System.out.println("Subject 2: " + this.subject2);
        System.out.println("Subject 3: " + this.subject3);
        System.out.println("Subject 4: " + this.subject4);
        System.out.println("Subject 5: " + this.subject5);
        System.out.printf("GPA: %.2f\n", this.GPA);
    }
}

public class CalcGPA{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GPA calculator = new GPA();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter marks for student " + i + " in 5 subjects (separated by spaces):");
            String[] marks = scanner.nextLine().split(" ");
            Student1 student = new Student1("Student " + i, marks[0], marks[1], marks[2], marks[3], marks[4]);
            student.calculateGPA(calculator);
            student.printResult();
        }
    }
}