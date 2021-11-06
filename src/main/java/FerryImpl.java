import vehicle.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FerryImpl implements Ferry {
    private  final int MAX_SIZE_PASSENGER=200;
    private  final int MAX_NUMER_OF_VEHICLE=50;
    private Set<Passenger> passengers=new HashSet<>();
    private Set<Vehicle> vehicles=new HashSet<>();
    private int earnedMoney;
    /**
     * Used vehicle space:
     *   1 Bicycle = 1
     *   1 Car = 5 Bicycles=5
     *   1 Bus = 4 cars=4*5= 20
     *   1 Lorry =2 buses=2*20=40
     */
    @Override
    public int countPassengers() {
        return passengers.size();
    }

    @Override
    public int countVehicleSpace() {
    /**int count = 0;
     for(Vehicle v: vehicles){
     count+= v.getVehicleSize();
     }
     return count;
     */
       return vehicles.stream().mapToInt(Vehicle::getSize).sum();
    }

    @Override
    public int countMoney() {
        return earnedMoney;
    }
    // Embark passenger, warning if not enough room
    @Override
    public void embark(Passenger p) {
        if(!hasRoom(p)) throw new IndexOutOfBoundsException("No enough space");
        payFee(p.getFee());/** pay passenger fee*/
        //add passager to set
        passengers.add(p);
    }

    @Override
    public void embark(Vehicle v) {
        //If vehicle already embarked, do nothing
        if (!vehicles.contains(v)) {
            //If not space for.
            if (!hasSpaceFor(v)) {
                throw new IndexOutOfBoundsException("The maximum number of vehicles on the ferry is reached.");
            }
            // Embark the passenger of the vehicle.
            for (Passenger passenger : v.getPassengers()) {
                embark(passenger);
            }
           payFee(v.getFee()); // Pay vehicle fee.
           vehicles.add(v);  //add the vehicles
        }
    }
    /** Clear (empty) ferry. */
    @Override
    public void disembark() {
       // Loop through vehicles and Passenger and remove all elements using stream
       //vehicles.remove(vehicles.stream());
        while (!vehicles.isEmpty()) {
            vehicles.remove(0);
        }
        while (!passengers.isEmpty()) {
            passengers.remove(0);
        }
        //passengers.clear();
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {
        // size of vehicle + vehicle space must be less than max number of vehicle
        return (v.getSize() + countVehicleSpace()<=MAX_NUMER_OF_VEHICLE);
    }

    @Override
    public boolean hasRoom(Passenger p) {
        return passengers.size() <=MAX_SIZE_PASSENGER;
    }
    private void payFee(int fee){ earnedMoney+=fee; }

    public static void main(String[] args) {
      /*
		FerryFactoryDesignPattern ferry=new FerryFactoryDesignPattern();

		ferry.getVehicle("Car", 1);
		ferry.getVehicle("BUS", 1);
		ferry.getVehicle("BICYCLE", 1);
		ferry.getVehicle("Lorry", 1);
		*/
        FerryImpl ferryImp=new FerryImpl();
        // Embark 5 cars with 4 Passenger each.

        for (int i = 0; i < 5; i++) {
            try {
                ferryImp.embark(new Car(4));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        // Embark 1 Lorry with 2 Passenger.
        try {
            ferryImp.embark(new Lorry(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        // Embark 5 buses with 15 Passenger each.
        for (int i = 0; i < 5; i++) {//IntStream.range(0,NoOfVehicles)
            try {
                ferryImp.embark(new Bus(15));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        // Embark 50 passenger.
        for (int i = 0; i < 50; i++) {
            try {
                ferryImp.embark(new Passenger());
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
        // Embark 6 bicycles
        for (int i = 0; i < 6; i++) {
            try {
                ferryImp.embark(new Bicycle());
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
       /* embarkWithPassengers(ferryImp,5,15, EmbarkType.BUS); // Embark 5 buses with 15 Passenger each.
        embarkWithPassengers(ferryImp,2,1, EmbarkType.LORRY); // Embark 1 Lorry with 2 Passenger.
        embarkWithPassengers(ferryImp,4,5, EmbarkType.CAR); // Embark 5 cars with 4 Passenger each.
        embarkWithPassengers(ferryImp,6,0, EmbarkType.CAR);// Embark 6 bicycles
        embarkWithPassengers(ferryImp,50,0, EmbarkType.PASSENGER);// Embark 50 passenger.
        embarkWithPassengers(ferryImp,6,0, EmbarkType.BICYCLE);// Embark 6 bicycles*/
    }
    /*private static void embarkWithPassengers(FerryImpl ferryImp, int NoOfPassengers, int NoOfVehicles, EmbarkType type){
        switch (type){
          *//*  case BUS -> IntStream.range(0,NoOfVehicles).map(ferryImp.embark(new Bus(NoOfPassengers)));
            case BICYCLE -> IntStream.range(0,NoOfVehicles).map(ferryImp.embark(new Bicycle(NoOfPassengers)));
            case LORRY -> IntStream.range(0,NoOfVehicles).map(ferryImp.embark(new Lorry(NoOfPassengers)));
            case CAR -> IntStream.range(0,NoOfVehicles).map(ferryImp.embark(new Car(NoOfPassengers)));
            case PASSENGER -> IntStream.range(0,NoOfVehicles).map(ferryImp.embark(new Passenger(NoOfPassengers)));*//*
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }*/
}
