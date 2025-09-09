# Use official OpenJDK 17 image
FROM openjdk:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the Maven build output JAR into the container
COPY target/*.jar app.jar

# Expose the port your app will run on
EXPOSE 8080

# Run the Spring Boot JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
