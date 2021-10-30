package VCC.carproducer;

import VCC.carproducer.Car.Car;
import VCC.carproducer.Requirement.CarTypeMapper;
import VCC.carproducer.Requirement.EngineType;
import VCC.carproducer.Requirement.Requirement;
import VCC.carproducer.Requirement.RequirementDoesNotMapToCarTypeException;
import VCC.carproducer.Validator.CarValidator;
import VCC.carproducer.Validator.CarValidatorResultPrinter;

public class CarProducer {
    public static void main(String[] args) {
        var carProducer = new CarProducer();
        var stationWagonRequirement = new Requirement(5, 5, false, false, false, EngineType.ICE);
        var carValidator = new CarValidator();

        Car stationWagon;
        try {
            stationWagon = carProducer.produce(stationWagonRequirement);
        } catch (RequirementDoesNotMapToCarTypeException e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return;
        }

        var result = carValidator.validate(stationWagonRequirement, stationWagon);
        CarValidatorResultPrinter.printResult(result);
    }

    public Car produce(Requirement requirement) throws RequirementDoesNotMapToCarTypeException
    {
        var mapper = new CarTypeMapper();
        var carType = mapper.mapRequirementToCarType(requirement);

        return new Car(carType, requirement.getEngineType(), requirement.getSeatCount());
    }
}
