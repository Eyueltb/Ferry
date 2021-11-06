package vehicle;

public class Lorry extends Vehicle {
    private static final int VEHICLE_SIZE = 40;
    private static final int MAX_NUMBER_OF_PASSENGERS = 2;
    private static final int PASSENGERS_FEE = 15;
    private static final int VEHICLE_FEE = 300;

    public Lorry(int passengers) {
        super(VEHICLE_SIZE, VEHICLE_FEE, MAX_NUMBER_OF_PASSENGERS, passengers, PASSENGERS_FEE);
    }
}
