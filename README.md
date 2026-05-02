# 🧸 ToyTrack API

API REST desenvolvida em **Java com Spring Boot** para gerenciamento de brinquedos infantis de uma empresa voltada para crianças de até **14 anos**.

O projeto implementa um **CRUD completo** da entidade `Brinquedo`, com persistência em banco **Oracle**, utilizando **Spring Data JPA** e arquitetura em camadas.

---

## 👥 Integrantes do Grupo

| Nome | RM |
|------|----|
| Olavo Porto Neves          | RM563558 |
| Pedro Henrique Dias França | RM561940 |
| Luiz Gustavo Gonçalves     | RM564495 |
| Altamir Lima               | RM562906 |
| Felipe Conte               | RM562248 |

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão |
|------------|--------|
| Java | 21 |
| Spring Boot | 4.x |
| Spring Web | — |
| Spring Data JPA | — |
| Oracle Database | ORACLE_FIAP |
| Oracle SQL Developer | — |
| Maven | — |
| Postman | — |

---

## 🗄️ Entidade Principal

### Brinquedo

Tabela no banco: `TDS_TB_Brinquedos`

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `id` | `Long` | Identificador único (PK, auto-gerado via Sequence) |
| `nome` | `String` | Nome do brinquedo |
| `tipo` | `String` | Tipo/categoria do brinquedo |
| `classificacao` | `String` | Classificação etária (ex: `6+`, `10+`) |
| `tamanho` | `String` | Tamanho físico (ex: `Pequeno`, `Médio`, `Grande`) |
| `preco` | `Double` | Preço do brinquedo |

---

## ⚙️ Configuração do Banco

Arquivo `src/main/resources/application.properties`:

```properties
spring.application.name=toytrack-api

# Oracle FIAP
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=SEU_RM
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# JPA / Hibernate
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```

> 📸 Print — configuração do `application.properties`:
>
> ![application.properties](caminho/para/seu/print-application-properties.png)

---

## 🔧 Dependências — Spring Initializr

> 📸 Print — tela do Spring Initializr com as dependências selecionadas:
>
> ![Spring Initializr](./assets/Captura de tela 2026-04-30 113111.pngg)

Dependências utilizadas (`pom.xml`):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc11</artifactId>
    <scope>runtime</scope>
</dependency>
```

---

## 🏗️ Arquitetura do Projeto

```
src/main/java/br/com/fiap/toytrack/
├── model/
│   └── Brinquedo.java
├── repository/
│   └── BrinquedoRepository.java
├── service/
│   └── BrinquedoService.java
├── controller/
│   └── BrinquedoController.java
└── ToytTrackApplication.java
```

---

## 📌 Fluxo da Aplicação

```
Postman (JSON)
     ↕ HTTP
Controller → Service → Repository
                           ↕ JPA / Persist
                      Oracle SQL Developer
                      (TDS_TB_Brinquedos)
```

---

## 📡 Endpoints da API

**URL base:** `http://localhost:8080/brinquedos`

---

### ✅ POST — Criar brinquedo

**Método:** `POST`  
**URL:** `http://localhost:8080/brinquedos`

**Body (JSON):**

```json
{
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacao": "8+",
  "tamanho": "Médio",
  "preco": 149.90
}
```

**Resposta esperada — `201 Created`:**

```json
{
  "id": 1,
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacao": "8+",
  "tamanho": "Médio",
  "preco": 149.90
}
```

> 📸 Print — requisição POST no Postman com status `201 Created`:
>
> ![POST Brinquedo](caminho/para/seu/print-post.png)

---

### 📋 GET — Listar todos os brinquedos

**Método:** `GET`  
**URL:** `http://localhost:8080/brinquedos`

**Resposta esperada — `200 OK`:**

```json
[
  {
    "id": 1,
    "nome": "Carrinho de Controle Remoto",
    "tipo": "Eletrônico",
    "classificacao": "8+",
    "tamanho": "Médio",
    "preco": 149.90
  },
  {
    "id": 2,
    "nome": "Boneca Articulada",
    "tipo": "Boneca",
    "classificacao": "3+",
    "tamanho": "Pequeno",
    "preco": 89.90
  }
]
```

> 📸 Print — requisição GET no Postman retornando a lista com status `200 OK`:
>
> ![GET todos](caminho/para/seu/print-get-todos.png)

---

### 🔍 GET — Buscar brinquedo por ID

**Método:** `GET`  
**URL:** `http://localhost:8080/brinquedos/1`

**Resposta esperada — `200 OK`:**

```json
{
  "id": 1,
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacao": "8+",
  "tamanho": "Médio",
  "preco": 149.90
}
```

**Caso não encontrado — `404 Not Found`**

> 📸 Print — busca por ID no Postman com status `200 OK`:
>
> ![GET por ID](caminho/para/seu/print-get-id.png)

---

### ✏️ PUT — Atualizar brinquedo

**Método:** `PUT`  
**URL:** `http://localhost:8080/brinquedos/1`

**Body (JSON):**

```json
{
  "nome": "Carrinho de Controle Remoto Turbo",
  "tipo": "Eletrônico",
  "classificacao": "10+",
  "tamanho": "Grande",
  "preco": 199.90
}
```

**Resposta esperada — `200 OK`:**

```json
{
  "id": 1,
  "nome": "Carrinho de Controle Remoto Turbo",
  "tipo": "Eletrônico",
  "classificacao": "10+",
  "tamanho": "Grande",
  "preco": 199.90
}
```

> 📸 Print — requisição PUT no Postman com status `200 OK`:
>
> ![PUT Brinquedo](caminho/para/seu/print-put.png)

---

### 🗑️ DELETE — Deletar brinquedo

**Método:** `DELETE`  
**URL:** `http://localhost:8080/brinquedos/1`

**Resposta esperada — `204 No Content`**

> 📸 Print — requisição DELETE no Postman com status `204 No Content`:
>
> ![DELETE Brinquedo](caminho/para/seu/print-delete.png)

---

## 🗃️ Validação no Banco Oracle

Após realizar operações de POST, PUT ou DELETE, validar a persistência no **Oracle SQL Developer**:

```sql
SELECT * FROM TDS_TB_Brinquedos;
```

**Exemplo de resultado esperado:**

| ID | NOME | TIPO | CLASSIFICACAO | TAMANHO | PRECO |
|----|------|------|---------------|---------|-------|
| 1 | Carrinho de Controle Remoto | Eletrônico | 8+ | Médio | 149.90 |
| 2 | Boneca Articulada | Boneca | 3+ | Pequeno | 89.90 |

> 📸 Print — resultado do `SELECT *` no SQL Developer confirmando a persistência:
>
> ![SQL Developer](caminho/para/seu/print-sql-developer.png)

---

## ▶️ Como Executar o Projeto

**1. Clonar o repositório:**

```bash
git clone URL_DO_REPOSITORIO
cd toytrack-api
```

**2. Configurar o banco Oracle:**

Editar `src/main/resources/application.properties` com suas credenciais Oracle FIAP.

**3. Executar a aplicação:**

```bash
mvn spring-boot:run
```

**4. Testar os endpoints:**

Importar as requisições no **Postman** e testar na URL base `http://localhost:8080/brinquedos`.
