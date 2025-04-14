# Usa una imagen oficial de OpenJDK como base
FROM openjdk:17-jdk-slim

# Etiqueta de los autores
LABEL authors="angda"

# Crea un directorio para la aplicación
WORKDIR /app

# Copia el jar generado por Spring Boot al contenedor
COPY target/AppTrip-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
