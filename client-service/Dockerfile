FROM openjdk:11-jre-slim

COPY target/client-service-0.0.1.jar /app/client-service-0.0.1.jar

ENTRYPOINT ["java", "-jar", "/app/client-service-0.0.1.jar"]
EXPOSE 8899
