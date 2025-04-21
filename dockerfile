# Builder
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder
WORKDIR /usr/src
COPY ./ /usr/src
RUN mvn clean package

# Server
FROM openjdk:21
WORKDIR /
COPY --from=builder /usr/src/target/picpay-1.0-SNAPSHOT.jar /picpay-1.0-SNAPSHOT.jar
ENV PORT=8080
ENV KAFKA_URL=localhost:9094
EXPOSE 8080
ENTRYPOINT ["java" ,"-jar" ,"/picpay-1.0-SNAPSHOT.jar"]