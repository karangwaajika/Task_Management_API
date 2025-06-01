FROM eclipse-temurin:24-jdk-alpine
WORKDIR /app
COPY target/task_management_api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
