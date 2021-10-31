package VCC.carproducer.Requirement;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import VCC.carproducer.Car.CarType;

public class RequirementFactory {
    private final InputStream inputStream;
    private final PrintStream printStream;

    public RequirementFactory(InputStream inputStream, PrintStream printStream)
    {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public Requirement create()
    {
        var scanner = new Scanner(inputStream);

        var carType = askForCarType(scanner);
        var seatCount = optionallyAskForSeatCount(scanner, carType);
        var engineType = askForEngineType(scanner);

        scanner.close();

        return new Requirement(
            carType,
            seatCount,
            engineType
        );
    }

    private CarType askForCarType(Scanner scanner)
    {
        var carTypeNames = new ArrayList<String>();
        for (CarType carType : CarType.values()) {
            carTypeNames.add(carType.getName());
        }

        printStream.println(String.format("What car type should the car be? (%s)", String.join(", ", carTypeNames)));
        var carTypeName = scanner.nextLine();

        for (var carType : CarType.values()) {
            if (carType.getName().equals(carTypeName)) {
                return carType;
            }
        }

        throw new IllegalArgumentException(String.format("\"%s\" is not a supported car type", carTypeName));
    }

    private int optionallyAskForSeatCount(Scanner scanner, CarType carType)
    {
        var permittedSeatCounts = carType.getPermittedSeatCounts();
        if (permittedSeatCounts.size() == 1) {
            var seatCount = permittedSeatCounts.get(0);
            printStream.println(String.format("Selecting seat count %d as it is the only one that %s supports.", seatCount, carType.getName()));

            return seatCount;
        }

        var permittedSeatCountStrings = new ArrayList<String>();
        for (var permittedSeatCount : permittedSeatCounts) {
            permittedSeatCountStrings.add(permittedSeatCount.toString());
        }

        printStream.println(String.format("How many seats should the %s have? (%s)", carType.getName(), String.join(", ", permittedSeatCountStrings)));
        var seatCount = scanner.nextInt();

        if (!permittedSeatCounts.contains(seatCount)) {
            throw new IllegalArgumentException(String.format("Car type \"%s\" does not allow %d seats", carType.getName(), seatCount));
        }

        return seatCount;
    }

    private EngineType askForEngineType(Scanner scanner)
    {
        var engineTypes = EngineType.values();
        var engineDescriptions = new ArrayList<String>();
        var index = 0;
        for (var engineType : engineTypes) {
            engineDescriptions.add(String.format("%d for %s", index, engineType.getName()));
            index++;
        }

        printStream.println(
            String.format(
                "What engine type should the car have? Enter %s.",
                String.join(", ", engineDescriptions)
            )
        );

        var engineTypeIndex = scanner.nextInt();
        if (engineTypes.length <= engineTypeIndex) {
            throw new IllegalArgumentException(String.format("\"%d\" does not map to an engine type", engineTypeIndex));
        }

        return engineTypes[engineTypeIndex];
    }
}
