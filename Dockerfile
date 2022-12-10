FROM openjdk:11
RUN mvn package -DskipTests
EXPOSE 8080
COPY target/footballer-0.0.1-SNAPSHOT.jar footballer.jar
ENTRYPOINT ["java","-jar","/footballer.jar"]