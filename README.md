# API Dado Coletado - Sondas Espaciais

## Configuração de Profiles e Banco de Dados

A aplicação possui suporte a dois ambientes/profiles configurados:

### 1. Profile `test` (H2 Database)
Utiliza banco de dados H2 em memória com Flyway habilitado para migrations automáticas e carga inicial:
- **JDBC URL:** `jdbc:h2:mem:sondadb`
- **Username:** `sa`
- **Password:** *(vazio)*
- **Console H2:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

#### Executando com o profile `test`:
```bash
# Windows (PowerShell)
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=test

# Linux / macOS
./mvnw spring-boot:run -Dspring-boot.run.profiles=test
```
*(O profile `test` já está definido como ativo por padrão no `application.properties`)*

---

### 2. Profile `dev` (MySQL)
Utiliza banco relacional MySQL persistente com validação de schema e migrations Flyway.

#### Passo 1: Subir o container MySQL via Docker
```bash
docker run --name mysql-sondadb \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=sondadb \
  -p 3306:3306 \
  -d mysql:8.0
```

#### Passo 2: Executar a aplicação no profile `dev`:
```bash
# Windows (PowerShell)
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev

# Linux / macOS
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

---

## Migrations com Flyway

O versionamento do banco de dados está localizado em `src/main/resources/db/migration`:
- **`V1__create_table_dado_coletado.sql`**: Criação da tabela `dado_coletado` com chaves, tipos e restrições.
- **`V2__insert_initial_dados.sql`**: Carga inicial contendo 3 registros distintos e coerentes de sondas espaciais (*Voyager 1*, *Curiosity Rover*, *Perseverance Rover*).

---

## Documentação da API (Swagger / OpenAPI)

Com a aplicação em execução, acesse a documentação interativa nos seguintes links:
- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) (ou [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html))
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

### Construir a imagem Docker:
```bash
docker build -t api-dado-coletado-silvio-556716-m2 .
```

### Executar o container:
```bash
# Executando no profile padrão (test - com H2)
docker run -p 8080:8080 api-dado-coletado-silvio-556716-m2

# Executando no profile dev (conectando ao MySQL)
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=dev api-dado-coletado-silvio-556716-m2
```

---

## Endpoints da API

| Método | Rota | Descrição | Status de Sucesso |
|---|---|---|---|
| `POST` | `/api/dados` | Registra um novo dado coletado por sonda | `201 CREATED` |
| `GET` | `/api/dados` | Lista todos os dados coletados | `200 OK` |
| `GET` | `/api/dados/{id}` | Busca um dado coletado pelo ID | `200 OK` |
| `PUT` | `/api/dados/{id}` | Atualiza um registro existente pelo ID | `200 OK` |
| `DELETE` | `/api/dados/{id}` | Remove um dado coletado pelo ID | `204 NO_CONTENT` |

### Exemplo de Payload para Cadastro (`POST /api/dados`):
```json
{
  "sondaNome": "James Webb Space Telescope",
  "agenciaEspacial": "NASA / ESA / CSA",
  "dataColeta": "2024-08-15",
  "tipoDado": "RADIACAO",
  "valorMedido": 12.45,
  "unidadeMedida": "microSievert/h"
}
```
Valores válidos para `tipoDado`:
- `TEMPERATURA`
- `PRESSAO`
- `RADIACAO`
- `COMPOSICAO_ATMOSFERICA`
- `VELOCIDADE_VENTO`
