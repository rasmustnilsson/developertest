#!/bin/sh

docker run -v "$(pwd)":/app/ --workdir /app/ maven:3.8-openjdk-17 mvn compile && mvn exec:java -Dexec.mainClass="VCC.carproducer.CarProducer"
