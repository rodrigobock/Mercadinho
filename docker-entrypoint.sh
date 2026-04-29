#!/bin/sh
set -e

PAYARA_JAR=$(find /opt/payara -maxdepth 2 -name "payara-micro*.jar" | head -1)
echo "[entrypoint] Usando JAR: $PAYARA_JAR"

exec java -jar "$PAYARA_JAR" \
    --deploy /opt/payara/Mercadinho-1.war \
    --port 8080 \
    --noCluster
