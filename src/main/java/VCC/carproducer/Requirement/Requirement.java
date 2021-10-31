package VCC.carproducer.Requirement;

import VCC.carproducer.Car.CarType;

public class Requirement {
    private final CarType carType;
    private final int seatCount;
    private final EngineType engineType;

    public Requirement(
        CarType carType,
        int seatCount,
        EngineType engineType
    ) {
        this.carType = carType;
        this.seatCount = seatCount;
        this.engineType = engineType;
    }

    public CarType getCarType()
    {
        return carType;
    }

    public int getSeatCount()
    {
        return seatCount;
    }

    public EngineType getEngineType()
    {
        return engineType;
    }
}
