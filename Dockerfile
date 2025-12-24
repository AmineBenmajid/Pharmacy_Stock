# Use an official Java 23 runtime as a parent image
FROM eclipse-temurin:23-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable jar file from the target folder to the container
# Replace 'pharmacy-0.0.1-SNAPSHOT.jar' with your actual jar name if different
COPY target/pharmacy-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]