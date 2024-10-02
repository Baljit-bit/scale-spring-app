# Use the official Maven image from Docker Hub
FROM docker.io/maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /spring-scale-app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Package the application (compile and create a JAR file)
RUN mvn clean package -DskipTests

# Use a smaller image for the runtime
FROM openjdk:17-jdk-alpine

# Set the working directory for the runtime container
WORKDIR /spring-scale-app

# Copy the JAR file from the build stage to the runtime stage
COPY --from=build /spring-scale-app/target/spring-boot-example-0.0.1-SNAPSHOT.jar /spring-scale-app/myapp.jar

EXPOSE 8081
# Define the command to run the application
ENTRYPOINT ["java", "-jar","/spring-scale-app/myapp.jar"]
