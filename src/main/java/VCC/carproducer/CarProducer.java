package VCC.carproducer;

import VCC.carproducer.Car.Car;
import VCC.carproducer.Requirement.Requirement;
import VCC.carproducer.Requirement.RequirementFactory;
import VCC.carproducer.Validator.CarValidator;
import VCC.carproducer.Validator.CarValidatorResultPrinter;

public class CarProducer {
    public static void main(String[] args) {
        var carProducer = new CarProducer();
        var carValidator = new CarValidator();
        var requirementFactory = new RequirementFactory(System.in, System.out);

        Requirement requirement = requirementFactory.create();
        var car = carProducer.produce(requirement);

        System.out.println(
            String.format(
                "Produced a %s with %d seats and engine type %s.",
                car.getCarType().getName(), car.getSeatCount(),
                car.getEngineType().getName()
            )
        );

        var result = carValidator.validate(requirement, car);
        CarValidatorResultPrinter.printResult(result);
    }

    public Car produce(Requirement requirement)
    {
        return new Car(
            requirement.getCarType(),
            requirement.getEngineType(),
            requirement.getSeatCount()
        );
    }
}
