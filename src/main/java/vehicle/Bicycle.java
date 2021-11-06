package vehicle;

public class Bicycle extends Vehicle {
    private static final int VEHICLE_SIZE = 1;
    private static final int MAX_NUMBER_OF_PASSENGERS = 1;
    private static final int PASSENGERS_FEE = 0;
    private static final int VEHICLE_FEE = 50;

    public Bicycle() {
        super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, 1, PASSENGERS_FEE);
    }
}
