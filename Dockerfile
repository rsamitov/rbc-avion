FROM ubuntu:latest
LABEL authors="roustam"

COPY target.jar app.jar

ENTRYPOINT ["java", "-jar",  "*.jar"]