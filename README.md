# Gestão de Pedidos API

API REST desenvolvida com Java e Spring Boot para gerenciamento de pedidos. O projeto permite cadastrar, consultar, atualizar e excluir pedidos, aplicando validação de dados, persistência com JPA, documentação OpenAPI e tratamento centralizado de erros.

## Tecnologias utilizadas

- Java 17
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Jakarta Validation
- H2 Database
- Springdoc OpenAPI 3.1.0
- Swagger UI
- JUnit
- MockMvc
- Maven

## Funcionalidades

A API oferece as seguintes operações:

- Cadastrar um pedido
- Listar todos os pedidos
- Buscar um pedido pelo ID
- Atualizar um pedido
- Excluir um pedido
- Validar os dados recebidos
- Retornar erros de validação em formato JSON
- Documentar e testar os endpoints pelo Swagger UI

## Link local do projeto 

http://localhost:8080/swagger-ui/index.html

## Estrutura do projeto

```text
src
├── main
│   ├── java
│   │   └── com.amanda.gestao_pedido
│   │       ├── GestaoPedidosApplication.java
│   │       ├── Pedido.java
│   │       ├── PedidoController.java
│   │       ├── PedidoService.java
│   │       ├── PedidoRepository.java
│   │       ├── GlobalExceptionHandler.java
│   │       └── ErroResposta.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com.amanda.gestao_pedido
            └── GestaoPedidoApplicationTests.java
