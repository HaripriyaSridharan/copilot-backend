# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the maintainer label
LABEL maintainer="your-email@example.com"

# Create a volume to mount the temporary files
VOLUME /tmp

# Expose port 8080 to the outside world
EXPOSE 8080

# Specify the JAR file location
ARG JAR_FILE=build/libs/copilot-1-0.0.1-SNAPSHOT.jar

# Add the JAR file to the container
ADD ${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app.jar"]
