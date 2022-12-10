FROM openjdk:11
EXPOSE 8080
RUN ./mvnw clean package
COPY target/footballer-0.0.1-SNAPSHOT.jar footballer.jar
ENTRYPOINT ["java","-jar","/footballer.jar"]