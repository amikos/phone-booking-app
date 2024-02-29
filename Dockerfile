FROM maven:3.8.4-openjdk-11 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM openjdk:11-jre

WORKDIR /app

COPY --from=builder /app/target/phone-booking-app.jar ./phone-booking-app.jar

CMD ["java", "-jar", "phone-booking-app.jar"]