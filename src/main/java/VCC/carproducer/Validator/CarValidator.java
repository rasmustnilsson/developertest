package VCC.carproducer.Validator;

import VCC.carproducer.Car.Car;
import VCC.carproducer.Car.CarType;
import VCC.carproducer.Requirement.Requirement;

public class CarValidator {
    public CarValidatorResult validate(Requirement requirement, Car car)
    {
        CarValidatorResult result = new CarValidatorResult();
        CarType carType = car.getCarType();

        if (!requirement.getCarType().equals(car.getCarType())) {
            String error = String.format(
                "The requirement expects the car to have the car type \"%s\" but it has \"%s\".",
                requirement.getCarType().getName(),
                car.getCarType().getName()
            );
            result.addError(error);
        }

        if (!requirement.getEngineType().equals(car.getEngineType())) {
            String error = String.format(
                "The requirement expects the car to have the engine type \"%s\" but it has \"%s\".",
                requirement.getEngineType().getName(),
                car.getEngineType().getName()
            );
            result.addError(error);
        }

        if (!carType.getPermittedSeatCounts().contains(car.getSeatCount())) {
            String error = String.format(
                "The requirement requires %d seats but the car type \"%s\" does not permit that.",
                requirement.getSeatCount(),
                carType.getName()
            );
            result.addError(error);
        }

        if (car.getSeatCount() != requirement.getSeatCount()) {
            String error = String.format(
                "The requirement expects the car to have %d seats but it has %d.",
                requirement.getSeatCount(),
                car.getSeatCount()
            );
            result.addError(error);
        }

        return result;
    }
}
