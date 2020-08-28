FROM openjdk:8
ADD build/libs/mccdataapi.jar mccdataapi.jar

EXPOSE 8080


ENTRYPOINT ["java", "-jar", "mccdataapi.jar"]
