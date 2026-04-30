# ToyTrack API

API REST desenvolvida em Java com Spring Boot para gerenciamento de brinquedos infantis de uma empresa voltada para crianças de até 14 anos.

O projeto implementa um CRUD completo da entidade Brinquedo, utilizando arquitetura em camadas:

- Model
- Repository
- Service
- Controller

A persistência dos dados é realizada em banco Oracle, utilizando Spring Data JPA.

---

## Tecnologias utilizadas

```bash
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Oracle Database
- Oracle SQL Developer
- Maven
- Postman
```

---

## Entidade principal

### Brinquedo

Tabela no banco:

```sql
TB_TDS_BRINQUEDOS
Campos:

Campo	Tipo	Descrição
id	Long	Identificador único
nome	String	Nome do brinquedo
tipo	String	Tipo do brinquedo
classificacaoIdade	Integer	Idade recomendada
preco	BigDecimal	Preço do brinquedo
marca	String	Marca do brinquedo
descricao	String	Descrição do brinquedo
Configuração do banco
```

Arquivo application.properties:

```cmd
spring.application.name=toytrack-api

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
```
Print sugerido: inserir imagem do arquivo application.properties mostrando a configuração do banco Oracle.

Endpoints da API

URL base:

http://localhost:8080/brinquedos
Criar brinquedo
Requisição

Método: POST

URL:

http://localhost:8080/brinquedos

JSON:

```JSON
{
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacaoIdade": 8,
  "preco": 149.90,
  "marca": "Hot Wheels",
  "descricao": "Carrinho elétrico com controle remoto indicado para crianças acima de 8 anos."
}
```
Resposta esperada
```JSON
{
  "id": 1,
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacaoIdade": 8,
  "preco": 149.90,
  "marca": "Hot Wheels",
  "descricao": "Carrinho elétrico com controle remoto indicado para crianças acima de 8 anos."
}
```
Print sugerido: requisição POST no Postman com status 201 ou 200.

Listar todos os brinquedos
Requisição

Método: GET

URL:

http://localhost:8080/brinquedos
Resposta esperada
[
  {
    "id": 1,
    "nome": "Carrinho de Controle Remoto",
    "tipo": "Eletrônico",
    "classificacaoIdade": 8,
    "preco": 149.90,
    "marca": "Hot Wheels",
    "descricao": "Carrinho elétrico com controle remoto indicado para crianças acima de 8 anos."
  }
]

Print sugerido: requisição GET no Postman retornando a lista de brinquedos.

Buscar brinquedo por ID
Requisição

Método: GET

URL:

http://localhost:8080/brinquedos/1
Resposta esperada
{
  "id": 1,
  "nome": "Carrinho de Controle Remoto",
  "tipo": "Eletrônico",
  "classificacaoIdade": 8,
  "preco": 149.90,
  "marca": "Hot Wheels",
  "descricao": "Carrinho elétrico com controle remoto indicado para crianças acima de 8 anos."
}

Print sugerido: busca por ID no Postman.

Atualizar brinquedo
Requisição

Método: PUT

URL:

http://localhost:8080/brinquedos/1

JSON:

{
  "nome": "Carrinho de Controle Remoto Turbo",
  "tipo": "Eletrônico",
  "classificacaoIdade": 10,
  "preco": 199.90,
  "marca": "Hot Wheels",
  "descricao": "Carrinho turbo com controle remoto indicado para crianças acima de 10 anos."
}
Resposta esperada
{
  "id": 1,
  "nome": "Carrinho de Controle Remoto Turbo",
  "tipo": "Eletrônico",
  "classificacaoIdade": 10,
  "preco": 199.90,
  "marca": "Hot Wheels",
  "descricao": "Carrinho turbo com controle remoto indicado para crianças acima de 10 anos."
}

Print sugerido: requisição PUT no Postman mostrando o brinquedo atualizado.

Deletar brinquedo
Requisição

Método: DELETE

URL:

http://localhost:8080/brinquedos/1
Resposta esperada
204 No Content

Print sugerido: requisição DELETE no Postman.

Validação no banco Oracle

Após criar ou atualizar um brinquedo, executar no Oracle SQL Developer:

SELECT * FROM TB_TDS_BRINQUEDOS;

Exemplo de resultado esperado:

ID	NOME	TIPO	CLASSIFICACAO_IDADE	PRECO	MARCA	DESCRICAO
1	Carrinho de Controle Remoto	Eletrônico	8	149.90	Hot Wheels	Carrinho elétrico com controle remoto

Print sugerido: consulta SELECT * FROM TB_TDS_BRINQUEDOS; mostrando que o registro foi persistido no banco.

Como executar o projeto
Clonar o repositório:
git clone URL_DO_REPOSITORIO
Entrar na pasta do projeto:
cd toytrack-api
Configurar o banco Oracle no arquivo:
src/main/resources/application.properties
Executar a aplicação:
mvn spring-boot:run
Testar os endpoints no Postman.
Conclusão

Este projeto demonstra a criação de uma API REST completa utilizando Java, Spring Boot e Oracle Database, aplicando boas práticas de arquitetura em camadas e persistência com Spring Data JPA.
