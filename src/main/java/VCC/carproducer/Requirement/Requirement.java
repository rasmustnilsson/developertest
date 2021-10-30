package VCC.carproducer.Requirement;

public class Requirement {
    private final int doorCount;
    private final int seatCount;
    private final boolean hasHighBody;
    private final boolean hasHighSuspension;
    private final boolean hasRemovableRoof;
    private final EngineType engineType;

    public Requirement(
        int doorCount,
        int seatCount,
        boolean hasHighBody,
        boolean hasHighSuspension,
        boolean hasRemovableRoof,
        EngineType engineType
    ) {
        this.doorCount = doorCount;
        this.seatCount = seatCount;
        this.hasHighBody = hasHighBody;
        this.hasHighSuspension = hasHighSuspension;
        this.hasRemovableRoof = hasRemovableRoof;
        this.engineType = engineType;
    }

    public int getDoorCount()
    {
        return doorCount;
    }

    public int getSeatCount()
    {
        return seatCount;
    }

    public boolean hasHighBody()
    {
        return hasHighBody;
    }

    public boolean hasHighSuspension()
    {
        return hasHighSuspension;
    }

    public boolean hasRemovableRoof()
    {
        return hasRemovableRoof;
    }

    public EngineType getEngineType()
    {
        return engineType;
    }
}
