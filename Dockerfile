FROM openjdk:23-oracle
WORKDIR /app
COPY build/libs/StudentAccountingApplications-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]