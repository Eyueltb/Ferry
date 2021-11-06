package vehicle;

import lombok.Data;

@Data
public class Passenger {
    private static final int FEE_WITHOUT_VEHICLE = 25;
    private int fee;
    public Passenger(){this(FEE_WITHOUT_VEHICLE);}
    public Passenger(int fee){this.fee=fee;}
}
