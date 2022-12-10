FROM maven:3.6.1-jdk-8-alpine AS maven
COPY ./ ./
RUN mvn clean package
FROM openjdk:8-jre-alpine3.9
COPY --from=maven target/footballer-0.0.1-SNAPSHOT.jar /footballer.jar
EXPOSE 8080
CMD ["java", "-jar", "/footballer.jar"]