FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean -e -B package -DskipTests=true
FROM registry.access.redhat.com/ubi9/openjdk-17@sha256:583a34c0896ee86dd3c73ab04b0e36bd701ab9d39cbb0ff95acc23c7ce1f1dcb
WORKDIR /app
COPY --from=builder /app/target/kitchen-service-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "./kitchen-service-0.0.1-SNAPSHOT.jar"]
