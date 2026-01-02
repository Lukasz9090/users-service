git s# Etap 1: Budowanie (używamy lekkiego obrazu z Mavenem)
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etap 2: Uruchamianie
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]