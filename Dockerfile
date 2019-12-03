FROM java:8
EXPOSE 8080
ADD target/ticketingSystem-0.0.1-SNAPSHOT.jar ticketingSystem.jar
ARG JAR_FILE=target/ticketingSystem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ticketingSystem.jar"]

