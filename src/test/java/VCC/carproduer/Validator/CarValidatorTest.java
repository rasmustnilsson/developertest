package VCC.carproduer.Validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import VCC.carproducer.Car.Car;
import VCC.carproducer.Car.CarType;
import VCC.carproducer.Requirement.EngineType;
import VCC.carproducer.Requirement.Requirement;
import VCC.carproducer.Validator.CarValidator;

public class CarValidatorTest
{
    @Test
    public void testValidatorAddsNoErrors()
    {
        var car = new Car(CarType.CABRIOLET, EngineType.BEV, 2);
        var requirement = new Requirement(CarType.CABRIOLET, 2, EngineType.BEV);
        var validator = new CarValidator();

        var result = validator.validate(requirement, car);

        assertTrue(result.carIsValid());
    }

    @Test
    public void testValidatorAddsErrors()
    {
        var car = new Car(CarType.CABRIOLET, EngineType.BEV, 3);
        var requirement = new Requirement(CarType.SEDAN, 5, EngineType.HYBRID);
        var validator = new CarValidator();

        var result = validator.validate(requirement, car);

        assertFalse(result.carIsValid());
        assertSame(4, result.getErrors().size());
        assertEquals(
            String.format(
                "The requirement expects the car to have the car type \"%s\" but it has \"%s\".",
                requirement.getCarType().getName(),
                car.getCarType().getName()
            ),
            result.getErrors().get(0)
        );
        assertEquals(
            String.format(
                "The requirement expects the car to have the engine type \"%s\" but it has \"%s\".",
                requirement.getEngineType().getName(),
                car.getEngineType().getName()
            ),
            result.getErrors().get(1)
        );
        assertEquals(
            String.format(
                "The requirement requires 5 seats but the car type \"%s\" does not permit that.",
                CarType.CABRIOLET.getName()
            ),
            result.getErrors().get(2)
        );
        assertEquals(
            "The requirement expects the car to have 5 seats but it has 3.",
            result.getErrors().get(3)
        );
    }
}
