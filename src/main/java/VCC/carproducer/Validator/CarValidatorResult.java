package VCC.carproducer.Validator;

import java.util.ArrayList;
import java.util.List;

public class CarValidatorResult {
    private final List<String> errors = new ArrayList<String>();

    public void addError(String error)
    {
        errors.add(error);
    }

    public boolean carIsValid()
    {
        return errors.isEmpty();
    }

    public List<String> getErrors()
    {
        return errors;
    }
}
