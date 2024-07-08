FROM eclipse-temurin:17
WORKDIR /app
COPY target/organization-service-0.0.1-SNAPSHOT.jar /app/organization-service.jar
ENTRYPOINT ["java", "-jar", "organization-service.jar"]