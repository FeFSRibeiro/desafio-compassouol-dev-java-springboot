FROM maven:3.8.2-adoptopenjdk-11 AS builder
COPY ./desafio .
RUN mvn clean install

FROM openjdk:11.0.12-jre-slim
COPY --from=builder ./target/desafio-1.0.jar desafio.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "desafio.jar"]
