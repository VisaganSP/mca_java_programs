import java.util.Random;
import java.util.Scanner;

public class QuadraticEquGeneric<T extends Number> {
    private Scanner scanner;

    public QuadraticEquGeneric() {
        scanner = new Scanner(System.in);
    }

    public T getUserInput(String prompt) throws InvalidInputException {
        System.out.print(prompt);
        String input = scanner.nextLine();

        try {
            return (T) Double.valueOf(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input. Please enter a numeric value for coefficients.");
        }
    }

    public QuadraticEquation<T> generateEquation(T x) {
        Random random = new Random();
        T a = (T) Double.valueOf(random.nextDouble()); // Random coefficient for 'a'
        T b = (T) Double.valueOf(random.nextDouble()); // Random coefficient for 'b'
        T c = (T) Double.valueOf(random.nextDouble()); // Random coefficient for 'c'

        return new QuadraticEquation<>(a, b, c);
    }

    public static void main(String[] args) {
        QuadraticEquGeneric<Double> generator = new QuadraticEquGeneric<>();

        Double x = null;

        // Keep asking for input until a valid numeric value is entered
        while (true) {
            try {
                x = generator.getUserInput("Enter a numeric value for 'x': ");
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }

        QuadraticEquation<Double> equation1 = generator.generateEquation(x);
        QuadraticEquation<Double> equation2 = generator.generateEquation(x);

        System.out.println("\nGenerated Quadratic Equations:");
        equation1.printEquation();
        equation2.printEquation();
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class QuadraticEquation<T extends Number> {
    private T a, b, c;

    public QuadraticEquation(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void printEquation() {
        System.out.println("Quadratic Equation: " + a + "x^2 + " + b + "x + " + c);
    }
}