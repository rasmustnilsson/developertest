package VCC.carproducer.Requirement;

public class RequirementDoesNotMapToCarTypeException extends Exception {
    public RequirementDoesNotMapToCarTypeException()
    {
        super("The requirement does not match any known car type.");
    }
}
