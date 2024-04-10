FROM eclipse-temurin:17

LABEL maintainer="ancymaria7@gmail.com"

WORKDIR /app

COPY target/Employee-Management-System-0.0.1-SNAPSHOT.jar /app/Employee-Management-System.jar

ENTRYPOINT ["java", "-jar", "Employee-Management-System.jar"]