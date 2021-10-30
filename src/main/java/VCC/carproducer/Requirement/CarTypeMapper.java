package VCC.carproducer.Requirement;

import VCC.carproducer.Car.CarType;

public class CarTypeMapper {
    public CarType mapRequirementToCarType(Requirement requirement) throws RequirementDoesNotMapToCarTypeException
    {
        if (requirementMatchesCarType(requirement, CarType.STATION_WAGON)) {
            return CarType.STATION_WAGON;
        } else if (requirementMatchesCarType(requirement, CarType.SEDAN)) {
            return CarType.SEDAN;
        } else if (requirementMatchesCarType(requirement, CarType.SUV)) {
            return CarType.SUV;
        } else if (requirementMatchesCarType(requirement, CarType.CABRIOLET)) {
            return CarType.CABRIOLET;
        } else if (requirementMatchesCarType(requirement, CarType.COUPE)) {
            return CarType.COUPE;
        }

        throw new RequirementDoesNotMapToCarTypeException();
    }

    private boolean requirementMatchesCarType(Requirement requirement, CarType carType)
    {
        return
            requirement.getDoorCount() == carType.getDoorCount() &&
            requirement.hasHighBody() == carType.hasHighBody() &&
            requirement.hasHighSuspension() == carType.hasHighSuspension() &&
            requirement.hasRemovableRoof() == carType.hasRemovableRoof() &&
            carType.getPermittedSeatCounts().contains(requirement.getSeatCount());
    }
}
