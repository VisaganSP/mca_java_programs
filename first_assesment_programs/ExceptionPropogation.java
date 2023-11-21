public class ExceptionPropagation{

    // Method that throws an exception
    static void methodWithException() {
        try {
            // Code that may throw an exception
            int result = 10 / 0; // This will cause an ArithmeticException
            System.out.println("Result: " + result); // This won't be executed due to the exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        // The catch block for ArithmeticException is omitted intentionally
    }

    public static void main(String[] args) {
        try {
            // Call the method that throws an exception
            methodWithException();
        } catch (ArithmeticException e) {
            // Catch the unhandled ArithmeticException here
            System.out.println("Caught ArithmeticException in main method: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other exceptions that may occur
            System.out.println("Caught Exception in main method: " + e.getMessage());
        }

        // The program continues executing after handling the exception
        System.out.println("Program continues after handling exception.");
    }
}
