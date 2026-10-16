# ==========================================
# Estágio 1: Build da aplicação (Multi-Stage)
# ==========================================
FROM eclipse-temurin:25-jdk AS build
WORKDIR /app

# Copia arquivos do Maven Wrapper e dependências
COPY pom.xml mvnw ./
COPY .mvn .mvn
COPY src src

# Concede permissão de execução e compila gerando o artefato jar
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# ==========================================
# Estágio 2: Imagem final de execução (Runtime)
# ==========================================
FROM eclipse-temurin:25-jre
WORKDIR /app

# Copia o pacote JAR construído na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Porta padrão de acesso da API
EXPOSE 8080

# Execução da aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
