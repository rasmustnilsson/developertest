package VCC.carproducer.Car;

import VCC.carproducer.Requirement.EngineType;

public class Car {
    private final CarType carType;
    private final EngineType engineType;
    private final int seatCount;

    public Car(
        CarType carType,
        EngineType engineType,
        int seatCount
    ) {
        this.carType = carType;
        this.engineType = engineType;
        this.seatCount = seatCount;
    }

    public CarType getCarType()
    {
        return carType;
    }

    public EngineType getEngineType()
    {
        return engineType;
    }

    public int getSeatCount()
    {
        return seatCount;
    }
}
