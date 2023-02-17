FROM openjdk:17
ADD /build/libs/DudeWhereIsMyCar-0.0.1.jar DudeWhereIsMyCar.jar
ENTRYPOINT java -jar DudeWhereIsMyCar.jar