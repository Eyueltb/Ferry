import vehicle.Passenger;
import vehicle.Vehicle;



public interface Ferry {
    int countPassengers(); // Number of passengers on board
    int countVehicleSpace();  // Used vehicle space. One car is 1.
    int countMoney(); // Earned money
    void embark(Passenger p);  // Embark passenger, warning if not enough room
    void embark(Vehicle v);  // Embark vehicle, warning if not enough space
    void disembark(); // Clear (empty) ferry. The money earned remains
    boolean hasSpaceFor(Vehicle v);//true if we can embark Vehicle v
    boolean hasRoom(Passenger  p);  // true if we can embark passenger p

}
