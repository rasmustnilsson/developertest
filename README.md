# Developer test: Rasmus Nilsson

## Running with docker
To run tests run `./run-tests.sh`.
To run CarProducer run `./run-car-producer.sh`.
To run TrianglePrinter run `./run-triangle-printer.sh`.

## Running without docker
Compile by running: `mvn compile`.

To run tests run `mvn test`.
To run CarProducer run `java -cp target/classes VCC.carproducer.CarProducer`.
To run TrianglePrinter run `java -cp target/classes VCC.triangleprinter.TrianglePrinter`.
