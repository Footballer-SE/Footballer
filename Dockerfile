FROM openjdk:11
COPY ./ ./
RUN mvn clean package
EXPOSE 8080
ENV JAR_FILE = target/footballer-0.0.1-SNAPSHOT.jar
RUN mv ${JAR_FILE} footballer.jar
ENTRYPOINT ["java","-jar","/footballer.jar"]