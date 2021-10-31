package VCC.carproduer;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import VCC.carproducer.CarProducer;
import VCC.carproducer.Car.CarType;
import VCC.carproducer.Requirement.EngineType;
import VCC.carproducer.Requirement.Requirement;

public class CarProducerTest
{
    @Test
    public void testShouldReturnExpectedCar()
    {
        var expectedSeatCount = 8;
        var requirement = new Requirement(CarType.SUV, expectedSeatCount, EngineType.BEV);
        var producer = new CarProducer();

        var car = producer.produce(requirement);

        assertSame(CarType.SUV, car.getCarType());
        assertSame(EngineType.BEV, car.getEngineType());
        assertSame(expectedSeatCount, car.getSeatCount());
    }
}
