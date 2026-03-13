# ================================
# Stage 1: Build
# ================================
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests -B

# ================================
# Stage 2: Run
# ================================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Add a non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Set ownership
RUN chown appuser:appgroup app.jar

USER appuser

# Expose the application port
EXPOSE 8080

# Environment variables (override at runtime)
ENV PORT=8080
ENV DB_URL=""
ENV DB_USERNAME=""
ENV DB_PASSWORD=""

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]