package VCC.carproduer.Requirement;

import static org.junit.Assert.assertSame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import VCC.carproducer.Car.CarType;
import VCC.carproducer.Requirement.EngineType;
import VCC.carproducer.Requirement.RequirementFactory;

public class RequirementFactoryTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testShouldCreateRequirement()
    {
        var carName = CarType.SEDAN.getName();
        var engineTypeName = EngineType.BEV.getName();
        var input = String.format("%s\n1", carName, engineTypeName);
        var factory = createFactory(input);

        var requirement = factory.create();

        assertSame(CarType.SEDAN, requirement.getCarType());
        assertSame(CarType.SEDAN.getPermittedSeatCounts().get(0), requirement.getSeatCount());
        assertSame(EngineType.BEV, requirement.getEngineType());
    }

    @Test
    public void testShouldCreateRequirementForCarTypeThatHasMultiplePermittedSeatCounts()
    {
        var expectedSeatCount = 5;
        var carName = CarType.SUV.getName();
        var engineTypeName = EngineType.BEV.getName();
        var input = String.format("%s\n%d\n1", carName, expectedSeatCount, engineTypeName);
        var factory = createFactory(input);

        var requirement = factory.create();

        assertSame(CarType.SUV, requirement.getCarType());
        assertSame(expectedSeatCount, requirement.getSeatCount());
        assertSame(EngineType.BEV, requirement.getEngineType());
    }

    @Test
    public void testShouldThrowExceptionWhenCarTypeIsNotSupported()
    {
        var factory = createFactory("not-supported-car-type");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("\"not-supported-car-type\" is not a supported car type");

        factory.create();
    }

    @Test
    public void testShouldThrowExceptionWhenSeatCountIsNotSupported()
    {
        var expectedSeatCount = 1;
        var carName = CarType.SUV.getName();
        var input = String.format("%s\n%d\n1", carName, expectedSeatCount);
        var factory = createFactory(input);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(String.format("Car type \"%s\" does not allow %d seats", carName, expectedSeatCount));

        factory.create();
    }

    @Test
    public void testShouldThrowExceptionWhenEngineTypeIsNotSupported()
    {
        var engineTypeIndex = 4;
        var carName = CarType.SEDAN.getName();
        var input = String.format("%s\n%d", carName, engineTypeIndex);
        var factory = createFactory(input);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(String.format("\"%d\" does not map to an engine type", engineTypeIndex));

        factory.create();
    }

    private RequirementFactory createFactory(String input)
    {
        var mockInputStream = new ByteArrayInputStream(input.getBytes());
        var mockPrintStream = new PrintStream(new ByteArrayOutputStream());

        return new RequirementFactory(mockInputStream, mockPrintStream);
    }
}
