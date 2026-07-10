# Eclipse Temurin 21 slim
FROM eclipse-temurin:21-jdk-alpine

ARG JAR_FILE=target/*.jar

WORKDIR /app

COPY ${JAR_FILE} app.jar

EXPOSE 8484

ENTRYPOINT ["java", "-jar", "app.jar"]