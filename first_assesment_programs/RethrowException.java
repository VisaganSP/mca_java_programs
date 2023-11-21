public class RethrowException{

    // Method that initially throws an exception
    static void someMethod2() throws Exception {
        System.out.println("someMethod2 is throwing an exception");
        throw new Exception("Exception from someMethod2");
    }

    // Method that catches the exception and rethrows it
    static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("someMethod caught an exception");
            // Re-throwing the caught exception
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            // Call someMethod from the main method
            someMethod();
        } catch (Exception e) {
            // Catch the rethrown exception and print the stack trace
            System.out.println("Exception caught in main method:");
            e.printStackTrace();
        }
    }
}
