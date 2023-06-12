FROM openjdk:17
ADD /build/libs/dude_where_is_my_car-0.0.1.jar DudeWhereIsMyCar.jar
ENTRYPOINT java -jar DudeWhereIsMyCar.jar