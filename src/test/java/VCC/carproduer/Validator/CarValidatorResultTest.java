package VCC.carproduer.Validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import VCC.carproducer.Validator.CarValidatorResult;

public class CarValidatorResultTest
{
    @Test
    public void testCarIsValidIfNoErrorsExist()
    {
        var result = new CarValidatorResult();
        assertTrue(result.carIsValid());
        assertTrue(result.getErrors().isEmpty());
    }

    @Test
    public void testCarIsNotValidIfErrorsExist()
    {
        var result = new CarValidatorResult();
        result.addError("test-error");
        assertFalse(result.carIsValid());
        assertFalse(result.getErrors().isEmpty());
    }
}
