package vehicle;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
public abstract class Vehicle {
    private static final int MIN_NUMBER_OF_PASSENGERS = 1;
    protected Set<Passenger> passengers=new HashSet<>();
    protected int size, fee;

    public Vehicle(int vehicleSize, int vehicleFee,
                   int MAX_NUMBER_OF_PASSENGERS, int numberOfPassengers,
                   int passengerFee){
        // Check if Passengers can't fit in the vehicle
        this.size=vehicleSize;
        this.fee=vehicleFee;
        // Add Passengers */
        for(int i=0;i < numberOfPassengers;i++)
            passengers.add(new Passenger(passengerFee));
        //passengers.add(IntStream.range(0,numberOfPassengers).mapToObj(operand -> new Passenger(passengerFee)).collect(Collectors.toList()).get(0));
    }
}
