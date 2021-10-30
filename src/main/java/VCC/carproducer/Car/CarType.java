package VCC.carproducer.Car;

import java.util.Arrays;
import java.util.List;

public enum CarType {
    STATION_WAGON ("station wagon", 5, false, false, false, Arrays.asList(5, 7)),
    SEDAN ("sedan", 4, false, false, false, Arrays.asList(5)),
    SUV ("SUV", 5, true, true, false, Arrays.asList(5, 7, 8)),
    CABRIOLET ("cabriolet", 2, false, false, true, Arrays.asList(2, 4)),
    COUPE ("coupé", 4, false, false, false, Arrays.asList(4));

    private final String name;
    private final int doorCount;
    private final boolean hasHighBody;
    private final boolean hasHighSuspension;
    private final boolean hasRemovableRoof;
    private final List<Integer> permittedSeatCounts;

    private CarType(
        String name,
        int doorCount,
        boolean hasHighBody,
        boolean hasHighSuspension,
        boolean hasRemovableRoof,
        List<Integer> permittedSeatCounts
    ) {
        this.name = name;
        this.doorCount = doorCount;
        this.hasHighBody = hasHighBody;
        this.hasHighSuspension = hasHighSuspension;
        this.hasRemovableRoof = hasRemovableRoof;
        this.permittedSeatCounts = permittedSeatCounts;
    }

    public String getName()
    {
        return name;
    }

    public int getDoorCount()
    {
        return doorCount;
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

    public List<Integer> getPermittedSeatCounts()
    {
        return permittedSeatCounts;
    }
}
