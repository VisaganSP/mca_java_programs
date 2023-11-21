import java.util.Scanner;

class AreaCalculator {
    double calculateArea(int sideLength) {
        return sideLength * sideLength;
    }

    double calculateArea(int length, int width) {
        return length * width;
    }
}

public class AreaCalculationMethodOverload {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();
        Scanner in = new Scanner(System.in);

        // Calculate and print the area of a square
        System.out.println("Enter side length of the square, you wanna calculate the area: ");
        int squareSideLength = in.nextInt();

        double squareArea = calculator.calculateArea(squareSideLength);
        System.out.println("Area of square with side length " + squareSideLength + ": " + squareArea);

        System.out.println();

        System.out.println("Enter rectangle length, you wanna calculate the area: ");
        int rectangleLength = in.nextInt();
        System.out.println("Enter rectangle width, you wanna calculate the area: ");
        int rectangleWidth = in.nextInt();

        double rectangleArea = calculator.calculateArea(rectangleLength, rectangleWidth);
        System.out.println("Area of rectangle with length " + rectangleLength + " and width " + rectangleWidth + ": " + rectangleArea);

        in.close();
    }
}