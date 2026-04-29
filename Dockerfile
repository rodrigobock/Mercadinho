# Stage 1: Build
FROM maven:3.8.6-eclipse-temurin-8 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -q

COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime — Payara Micro 6 (Jakarta EE 9 compatível)
FROM payara/micro:6.2023.5

USER root

# WAR em path estável fora do VOLUME /opt/payara/deployments
COPY --from=builder /app/target/Mercadinho-1.war /opt/payara/Mercadinho-1.war
COPY docker-entrypoint.sh /docker-entrypoint.sh
RUN chown payara:payara /opt/payara/Mercadinho-1.war && \
    sed -i 's/\r$//' /docker-entrypoint.sh && \
    chmod +x /docker-entrypoint.sh

USER payara
EXPOSE 8080
ENTRYPOINT ["/docker-entrypoint.sh"]
