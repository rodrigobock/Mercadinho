# Stage 1: Build
FROM maven:3.8.6-eclipse-temurin-8 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -q

COPY src ./src

# Variáveis de conexão com o banco — sobrescreva via --build-arg no docker build
ARG SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/mercadinho
ARG SPRING_DATASOURCE_USERNAME=postgres
ARG SPRING_DATASOURCE_PASSWORD=postgres

# Substitui as configs de conexão nos arquivos de configuração antes do build
RUN sed -i \
        -e "s|value=\"jdbc:postgresql://localhost:5432/mercadinho\"|value=\"${SPRING_DATASOURCE_URL}\"|" \
        -e "s|<property name=\"jakarta.persistence.jdbc.user\" value=\"[^\"]*\"/>|<property name=\"jakarta.persistence.jdbc.user\" value=\"${SPRING_DATASOURCE_USERNAME}\"/>|" \
        -e "s|<property name=\"jakarta.persistence.jdbc.password\" value=\"[^\"]*\"/>|<property name=\"jakarta.persistence.jdbc.password\" value=\"${SPRING_DATASOURCE_PASSWORD}\"/>|" \
        src/main/resources/META-INF/persistence.xml && \
    sed -i \
        -e "s|hibernate.connection.url=.*|hibernate.connection.url=${SPRING_DATASOURCE_URL}|" \
        -e "s|hibernate.connection.username=.*|hibernate.connection.username=${SPRING_DATASOURCE_USERNAME}|" \
        -e "s|hibernate.connection.password=.*|hibernate.connection.password=${SPRING_DATASOURCE_PASSWORD}|" \
        src/main/resources/hibernate.properties

RUN mvn clean package -DskipTests

# Stage 2: Runtime — Payara Server Full 6 (Jakarta EE 9 compatível)
FROM payara/server-full:6.2023.5

# Copia o WAR para a pasta de auto-deploy do Payara
COPY --from=builder /app/target/Mercadinho-1.war $DEPLOY_DIR

# 8080 = HTTP da aplicação | 4848 = Console admin do Payara
EXPOSE 8080 4848
