# Stage 1: Build
FROM maven:3.8.6-eclipse-temurin-8 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -q

COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime — Payara Micro 6 (Jakarta EE 9 compatível)
FROM payara/micro:6.2023.5

# Instala zip para reempacotar o WAR no entrypoint
USER root
RUN apk add --no-cache zip

# WAR vai para staging; será patchado com as env vars em runtime
COPY --from=builder /app/target/Mercadinho-1.war /tmp/Mercadinho-1.war
COPY docker-entrypoint.sh /docker-entrypoint.sh
# Remove CRLF caso o arquivo venha do Windows, e torna executável
RUN sed -i 's/\r$//' /docker-entrypoint.sh && chmod +x /docker-entrypoint.sh

USER payara
EXPOSE 8080
ENTRYPOINT ["/docker-entrypoint.sh"]
