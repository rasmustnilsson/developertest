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
        var requirement = new Requirement(2, 2, false, false, true, EngineType.BEV);
        var validator = new CarValidator();

        var result = validator.validate(requirement, car);

        assertTrue(result.carIsValid());
    }

    @Test
    public void testValidatorAddsErrorsOne()
    {
        var car = new Car(CarType.CABRIOLET, EngineType.BEV, 3);
        var requirement = new Requirement(5, 5, true, true, false, EngineType.HYBRID);
        var validator = new CarValidator();

        var result = validator.validate(requirement, car);

        assertFalse(result.carIsValid());
        assertSame(7, result.getErrors().size());
        assertEquals(String.format("The requirement expects the car to have 5 doors but it has %d.", CarType.CABRIOLET.getDoorCount()), result.getErrors().get(0));
        assertEquals("The requirement expects the car to have a high body but it does not.", result.getErrors().get(1));
        assertEquals("The requirement expects the car to have a high suspension but it does not.", result.getErrors().get(2));
        assertEquals("The requirement expects the car to not have a removable roof but it does.", result.getErrors().get(3));
        assertEquals(String.format("The requirement expects the car to have the engine type %s but it has %s.", EngineType.HYBRID.getName(), EngineType.BEV.getName()), result.getErrors().get(4));
        assertEquals(String.format("The requirement requires 5 seats but the car type %s does not permit that.", CarType.CABRIOLET.getName()), result.getErrors().get(5));
        assertEquals("The requirement expects the car to have 5 seats but it has 3.", result.getErrors().get(6));
    }

    @Test
    public void testValidatorAddsErrorsTwo()
    {
        var car = new Car(CarType.SUV, EngineType.BEV, 3);
        var requirement = new Requirement(1, 1, false, false, true, EngineType.HYBRID);
        var validator = new CarValidator();

        var result = validator.validate(requirement, car);

        assertFalse(result.carIsValid());
        assertSame(7, result.getErrors().size());
        assertEquals(String.format("The requirement expects the car to have 1 doors but it has %d.", CarType.SUV.getDoorCount()), result.getErrors().get(0));
        assertEquals("The requirement expects the car to not have a high body but it does.", result.getErrors().get(1));
        assertEquals("The requirement expects the car to not have a high suspension but it does.", result.getErrors().get(2));
        assertEquals("The requirement expects the car to have a removable roof but it does not.", result.getErrors().get(3));
        assertEquals(String.format("The requirement expects the car to have the engine type %s but it has %s.", EngineType.HYBRID.getName(), EngineType.BEV.getName()), result.getErrors().get(4));
        assertEquals(String.format("The requirement requires 1 seats but the car type %s does not permit that.", CarType.SUV.getName()), result.getErrors().get(5));
        assertEquals("The requirement expects the car to have 1 seats but it has 3.", result.getErrors().get(6));
    }
}
