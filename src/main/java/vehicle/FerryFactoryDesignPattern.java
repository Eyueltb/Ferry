package vehicle;

public class FerryFactoryDesignPattern {
    //Create instance of Vehicle based on the type of shape
    public Vehicle getVehicle(String VehicleType, int numberOfPassengers)
    {
        if (VehicleType == null) throw new NullPointerException("");

        else if (VehicleType.equalsIgnoreCase("CAR"))
        {
            return new Car(numberOfPassengers);
        }
        else if (VehicleType.equalsIgnoreCase("BUS"))
        {
            return new Bus(numberOfPassengers);
        }
        else if(VehicleType.equalsIgnoreCase("LORRY")){
            return new Lorry(numberOfPassengers);
        }
        else if(VehicleType.equalsIgnoreCase("BIYCLE")){
            return new Bicycle();
        }

        return null;
    }
}
