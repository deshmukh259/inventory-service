# Start with an official Java image from Docker Hub
FROM openjdk:17-jdk-slim


WORKDIR /app

COPY target/inventory-service-0.0.1-SNAPSHOT.jar inventory-service-0.0.1.jar

# Expose the port that the application will run on (optional)
EXPOSE 8090

ENTRYPOINT ["java","-jar","inventory-service-0.0.1.jar"]