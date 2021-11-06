package vehicle;

public class Car extends Vehicle {
    private static final int VEHICLE_SIZE = 5;
    private static final int MAX_NUMBER_OF_PASSENGERS = 4;
    private static final int VEHICLE_FEE = 100;
    private static final int PASSENGERS_FEE = 15;

    public Car(int passengers) {
        super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, passengers, PASSENGERS_FEE);
    }
}
