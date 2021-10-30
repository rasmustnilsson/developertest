package VCC.carproducer.Validator;

import VCC.carproducer.Car.Car;
import VCC.carproducer.Car.CarType;
import VCC.carproducer.Requirement.Requirement;

public class CarValidator {
    public CarValidatorResult validate(Requirement requirement, Car car)
    {
        CarValidatorResult result = new CarValidatorResult();
        CarType carType = car.getCarType();

        if (requirement.getDoorCount() != carType.getDoorCount()) {
            String error = String.format(
                "The requirement expects the car to have %d doors but it has %d.",
                requirement.getDoorCount(),
                carType.getDoorCount()
            );
            result.addError(error);
        }

        if (requirement.hasHighBody() != carType.hasHighBody()) {
            if (requirement.hasHighBody()) {
                result.addError("The requirement expects the car to have a high body but it does not.");
            } else {
                result.addError("The requirement expects the car to not have a high body but it does.");
            }
        }

        if (requirement.hasHighSuspension() != carType.hasHighSuspension()) {
            if (requirement.hasHighSuspension()) {
                result.addError("The requirement expects the car to have a high suspension but it does not.");
            } else {
                result.addError("The requirement expects the car to not have a high suspension but it does.");
            }
        }

        if (requirement.hasRemovableRoof() != carType.hasRemovableRoof()) {
            if (requirement.hasRemovableRoof()) {
                result.addError("The requirement expects the car to have a removable roof but it does not.");
            } else {
                result.addError("The requirement expects the car to not have a removable roof but it does.");
            }
        }

        if (!requirement.getEngineType().equals(car.getEngineType())) {
            String error = String.format(
                "The requirement expects the car to have the engine type %s but it has %s.",
                requirement.getEngineType().getName(),
                car.getEngineType().getName()
            );
            result.addError(error);
        }

        if (!carType.getPermittedSeatCounts().contains(car.getSeatCount())) {
            String error = String.format(
                "The requirement requires %d seats but the car type %s does not permit that.",
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
