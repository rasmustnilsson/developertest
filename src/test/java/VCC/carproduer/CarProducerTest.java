package VCC.carproduer;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import VCC.carproducer.CarProducer;
import VCC.carproducer.Car.CarType;
import VCC.carproducer.Requirement.EngineType;
import VCC.carproducer.Requirement.Requirement;
import VCC.carproducer.Requirement.RequirementDoesNotMapToCarTypeException;

public class CarProducerTest
{
    @Test(expected = RequirementDoesNotMapToCarTypeException.class)
    public void testShouldThrowErrorWhenRequirementDoesNotMatchACarType() throws RequirementDoesNotMapToCarTypeException
    {
        var producer = new CarProducer();
        producer.produce(new Requirement(1, 1, false, false, false, EngineType.BEV));
    }

    public void testShouldReturnExpectedCar() throws RequirementDoesNotMapToCarTypeException
    {
        var expectedSeatCount = 8;
        var requirement = new Requirement(5, expectedSeatCount, false, false, false, EngineType.BEV);
        var producer = new CarProducer();

        var car = producer.produce(requirement);

        assertSame(CarType.SUV, car.getCarType());
        assertSame(EngineType.BEV, car.getEngineType());
        assertSame(expectedSeatCount, car.getSeatCount());
    }
}
