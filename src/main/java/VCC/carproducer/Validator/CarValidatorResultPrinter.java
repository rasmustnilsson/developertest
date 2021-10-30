package VCC.carproducer.Validator;

public class CarValidatorResultPrinter {
    public static void printResult(CarValidatorResult result)
    {
        if (result.carIsValid()) {
            System.out.println("The produced car matches the requirement");
        } else {
            System.out.println("The produced car does not match the requirement");
            System.out.println("Errors:");
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
    }
}
