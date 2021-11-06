package vehicle;

public class Bus extends Vehicle {
    private static final int VEHICLE_SIZE = 20;//40 bicycle=2 buses
    private static final int MAX_NUMBER_OF_PASSENGERS = 20;
    private static final int PASSENGERS_FEE = 10;
    private static final int VEHICLE_FEE = 200;
    public Bus(int passengers) {
        super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, passengers, PASSENGERS_FEE);
    }
}
