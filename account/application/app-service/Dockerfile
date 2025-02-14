
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/app-service.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]

