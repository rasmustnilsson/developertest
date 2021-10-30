package VCC.carproduer.Requirement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import VCC.carproducer.Car.CarType;
import VCC.carproducer.Requirement.CarTypeMapper;
import VCC.carproducer.Requirement.EngineType;
import VCC.carproducer.Requirement.Requirement;
import VCC.carproducer.Requirement.RequirementDoesNotMapToCarTypeException;

public class CarTypeMapperTest
{
    @Test(expected = RequirementDoesNotMapToCarTypeException.class)
    public void testThrowsErrorIfNoCarTypeMatchesTheGivenRequirement() throws RequirementDoesNotMapToCarTypeException
    {
        var requirement = new Requirement(1, 1, false, false, false, EngineType.BEV);
        var carTypeMapper = new CarTypeMapper();
        carTypeMapper.mapRequirementToCarType(requirement);
    }

    @Test
    public void testReturnsStationWagonTypeWhenRequirementMatchesStationWagonType() throws RequirementDoesNotMapToCarTypeException
    {
        assertRequirementMapsToExpectedCarType(
            new Requirement(5, 5, false, false, false, EngineType.BEV),
            CarType.STATION_WAGON
        );
    }

    @Test
    public void testReturnsSedanTypeWhenRequirementMatchesSedanType() throws RequirementDoesNotMapToCarTypeException
    {
        assertRequirementMapsToExpectedCarType(
            new Requirement(4, 5, false, false, false, EngineType.BEV),
            CarType.SEDAN
        );
    }

    @Test
    public void testReturnsSUVTypeWhenRequirementMatchesSUVType() throws RequirementDoesNotMapToCarTypeException
    {
        assertRequirementMapsToExpectedCarType(
            new Requirement(5, 5, true, true, false, EngineType.BEV),
            CarType.SUV
        );
        assertRequirementMapsToExpectedCarType(
            new Requirement(5, 7, true, true, false, EngineType.BEV),
            CarType.SUV
        );
        assertRequirementMapsToExpectedCarType(
            new Requirement(5, 8, true, true, false, EngineType.BEV),
            CarType.SUV
        );
    }

    @Test
    public void testReturnsCabrioletTypeWhenRequirementMatchesCabrioletType() throws RequirementDoesNotMapToCarTypeException
    {
        assertRequirementMapsToExpectedCarType(
            new Requirement(2, 2, false, false, true, EngineType.BEV),
            CarType.CABRIOLET
        );
        assertRequirementMapsToExpectedCarType(
            new Requirement(2, 4, false, false, true, EngineType.BEV),
            CarType.CABRIOLET
        );
    }

    @Test
    public void testReturnsCoupeTypeWhenRequirementMatchesCoupeType() throws RequirementDoesNotMapToCarTypeException
    {
        assertRequirementMapsToExpectedCarType(
            new Requirement(4, 4, false, false, false, EngineType.BEV),
            CarType.COUPE
        );
        assertRequirementMapsToExpectedCarType(
            new Requirement(4, 4, false, false, false, EngineType.BEV),
            CarType.COUPE
        );
    }

    private void assertRequirementMapsToExpectedCarType(
        Requirement requirement,
        CarType expectedCarType
    ) throws RequirementDoesNotMapToCarTypeException {
        var carTypeMapper = new CarTypeMapper();
        assertEquals(carTypeMapper.mapRequirementToCarType(requirement), expectedCarType);
    }
}
