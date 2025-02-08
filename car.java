import java.util.ArrayList;
import java.util.List;

// This class represents a customer
class Customer {
    private String name;
    private String customerId;

    // Constructor to initialize a customer with a name.
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
}

// This class represents a car that can be rented or returned.
class Car {
    // Attributes of the car
    private String licensePlate;
    private String model;
    private boolean isRented;

    // Constructor to initialize a car with a given license plate and model.
    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        this.isRented = true;
    }

    public void returnCar() {
        this.isRented = false;
    }
}

// This class manages the rental agency.
class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;

    // Constructor to initialize empty lists of cars and customers.
    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Car rentCar(String licensePlate, String customerId) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && !car.isRented()) {
                car.rentCar();
                System.out.println("Car rented to customer " + customerId);
                return car;
            }
        }
        System.out.println("Car not available for rent.");
        return null;
    }

    public boolean returnCar(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && car.isRented()) {
                car.returnCar();
                System.out.println("Car returned successfully.");
                return true; // Indicate success
            }
        }
        System.out.println("Car not found or not rented.");
        return false; // Indicate failure
    }

    public int getNumberOfCars() {
        return cars.size(); // Returns the number of cars in the agency
    }
}

// The main class that runs the car rental system.
public class car {
    public static void main(String[] args) {
        // Create a rental agency system
        RentalAgency agency = new RentalAgency();

        // Add cars to the system (6 cars as requested)
        Car car1 = new Car("KBG", "BENTTLY 401");
        Car car2 = new Car("KGG", "GOLF GTI");
        Car car3 = new Car("KBQ", "Mercedes benz");
        Car car4 = new Car("KDT", "TOYOTA AXIO");
        Car car5 = new Car("KAA", "AUDI A4");
        Car car6 = new Car("KBB", "BMW X5");

        agency.addCar(car1);
        agency.addCar(car2);
        agency.addCar(car3);
        agency.addCar(car4);
        agency.addCar(car5);
        agency.addCar(car6);

        // Display the number of vehicles listed
        System.out.println("Number of vehicles listed: " + agency.getNumberOfCars());

        // Add customers to the system (names changed as requested)
        Customer customer1 = new Customer("JOHN DOE", "C001");
        Customer customer2 = new Customer("JANE SMITH", "C002");
        Customer customer3 = new Customer("ALICE JOHNSON", "C003");
        Customer customer4 = new Customer("BOB BROWN", "C004");

        agency.addCustomer(customer1);
        agency.addCustomer(customer2);
        agency.addCustomer(customer3);
        agency.addCustomer(customer4);

        // Rent and return a car
        agency.rentCar("KBG", "C001"); // Rent car with license plate "KBG" to customer "C001"
        agency.returnCar("KBG"); // Return car with license plate "KBG"
    }
}