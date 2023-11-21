class SomeClass {
    public SomeClass() throws Exception {
        // Simulate a condition that leads to constructor failure
        throw new Exception("Constructor failure: SomeClass cannot be instantiated.");
    }
}

public class exceptionObject {
    public static void main(String[] args) {
        try {
            // Attempt to create an object of SomeClass
            SomeClass someObject = new SomeClass();
        } catch (Exception e) {
            // Catch the exception thrown by the constructor
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
