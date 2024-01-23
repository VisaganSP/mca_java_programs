import java.util.HashMap;
import java.util.Map;

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        Car car = new Car("ABC123", "Toyota", "Camry", 30.0, 4);
        Truck truck = new Truck("XYZ789", "Ford", "F-150", 50.0, 1000.0);

        rentalSystem.addVehicle(car.getRegistrationNumber(), car);
        rentalSystem.addVehicle(truck.getRegistrationNumber(), truck);

        Customer customer = new Customer("C001", "John Doe");
        rentalSystem.addCustomer(customer.getCustomerId(), customer);

        rentalSystem.rentVehicle(customer.getCustomerId(), car.getRegistrationNumber(), 5);
        rentalSystem.returnVehicle(customer.getCustomerId());
    }
}

class Vehicle {
    private String registrationNumber;
    private String make;
    private String model;
    private double dailyRentalRate;

    public Vehicle(String registrationNumber, String make, String model, double dailyRentalRate) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.dailyRentalRate = dailyRentalRate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public double getDailyRentalRate() {
        return dailyRentalRate;
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String registrationNumber, String make, String model, double dailyRentalRate, int numberOfDoors) {
        super(registrationNumber, make, model, dailyRentalRate);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}

class Truck extends Vehicle {
    private double cargoCapacity;

    public Truck(String registrationNumber, String make, String model, double dailyRentalRate, double cargoCapacity) {
        super(registrationNumber, make, model, dailyRentalRate);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }
}

class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }
}

class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int daysRented;

    public Rental(Customer customer, Vehicle vehicle, int daysRented) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.daysRented = daysRented;
    }

    public double calculateRentalFee() {
        return vehicle.getDailyRentalRate() * daysRented;
    }
}

class RentalSystem {
    private Map<String, Vehicle> vehicles;
    private Map<String, Customer> customers;
    private Map<Customer, Rental> rentals;

    public RentalSystem() {
        vehicles = new HashMap<>();
        customers = new HashMap<>();
        rentals = new HashMap<>();
    }

    public void addVehicle(String registrationNumber, Vehicle vehicle) {
        vehicles.put(registrationNumber, vehicle);
    }

    public void addCustomer(String customerId, Customer customer) {
        customers.put(customerId, customer);
    }

    public void rentVehicle(String customerId, String registrationNumber, int daysRented) {
        Customer customer = customers.get(customerId);
        Vehicle vehicle = vehicles.get(registrationNumber);

        if (customer != null && vehicle != null) {
            Rental rental = new Rental(customer, vehicle, daysRented);
            rentals.put(customer, rental);
            System.out.println("Rental successful. Total rental fee: $" + rental.calculateRentalFee());
        } else {
            System.out.println("Invalid customer ID or vehicle registration number.");
        }
    }

    public void returnVehicle(String customerId) {
        Customer customer = customers.get(customerId);

        if (customer != null && rentals.containsKey(customer)) {
            Rental rental = rentals.get(customer);
            System.out.println("Vehicle returned. Rental fee: $" + rental.calculateRentalFee());
            rentals.remove(customer);
        } else {
            System.out.println("Invalid customer ID or no active rental for the customer.");
        }
    }
}