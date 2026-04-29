#!/bin/sh
set -e

STAGING=/tmp/war-staging
WAR_SRC=/opt/payara/Mercadinho-1.war
WAR_OUT=${DEPLOY_DIR}/Mercadinho-1.war

echo "[entrypoint] Aplicando configurações de banco..."

mkdir -p "$STAGING"
cd "$STAGING"
unzip -q "$WAR_SRC"

sed -i \
    -e "s|value=\"jdbc:postgresql://[^\"]*\"|value=\"${SPRING_DATASOURCE_URL}\"|" \
    -e "s|<property name=\"jakarta.persistence.jdbc.user\" value=\"[^\"]*\"/>|<property name=\"jakarta.persistence.jdbc.user\" value=\"${SPRING_DATASOURCE_USERNAME}\"/>|" \
    -e "s|<property name=\"jakarta.persistence.jdbc.password\" value=\"[^\"]*\"/>|<property name=\"jakarta.persistence.jdbc.password\" value=\"${SPRING_DATASOURCE_PASSWORD}\"/>|" \
    WEB-INF/classes/META-INF/persistence.xml

zip -qr "$WAR_OUT" .

echo "[entrypoint] Iniciando Payara Micro..."
exec java -jar "${PAYARA_MICRO_JAR}" \
    --deploy "$WAR_OUT" \
    --port 8080 \
    --noCluster
