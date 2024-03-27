# API de Gerenciamento de Produtos

[![Java CI com Maven](https://github.com/profdiegoaugusto/api-produtos-springboot/actions/workflows/maven-build.yml/badge.svg)](https://github.com/profdiegoaugusto/api-produtos-springboot/actions/workflows/maven-build.yml)

O objetivo deste repositório é apresentar um exemplo de APIs REST usando Java Spring Boot e Maven, bem como a implementação de testes unitários, testes de integração e integração contínua com GitHub Actions.

## Objetivo do Projeto

O objetivo deste projeto é servir como um guia para os alunos interessados em aprender sobre:

- Criação de APIs com Java Spring Boot;
- Implementação de testes unitários e de integração;
- Configuração da integração contínua usando GitHub Actions e maven.

## Branches Disponíveis

Para facilitar o acompanhamento do progresso do projeto, foram definidas as seguintes branches:

1. `inicio`: Projeto Spring Boot inicial vazio e configurado.
2. `api`: Implementação da API Produtos.
3. `config-ci`: Configuração do GitHub Actions para integração contínua.
4. `teste-unitario`: Implementação do pacote com testes unitários.
5. `teste-integracao`: Implementação do pacote com testes de integração.

# Tecnologias Usadas

- [Java](https://www.oracle.com/br/java/technologies/downloads/)
- [Spring Boot](https://spring.io/)
- [Spring initializr](https://start.spring.io/)
- [Maven](https://maven.apache.org/)
  - [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)
  - [Maven Failsafe Plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/)
- [MySQL](https://www.mysql.com/): Banco de Dados de Produção
- [H2 Database Engine](https://www.h2database.com/html/main.html): Banco de Dados de Testes

# Endpoint: O ponto de Acesso para as Funcionalidades da API

Em uma API (Interface de Programação de Aplicações), um endpoint representa um ponto de acesso ou uma URL específica que permite aos clientes interagir com determinadas funcionalidades ou recursos fornecidos pela API. Em termos simples, é o caminho através do qual os clientes podem enviar solicitações e receber respostas do servidor.

Os endpoints são definidos de acordo com o tipo de operação que desejamos realizar nos recursos da API. Por exemplo, se quisermos obter informações sobre um determinado produto, podemos ter um endpoint específico para isso. Da mesma forma, se quisermos adicionar um novo produto ao sistema, haverá um endpoint designado para essa funcionalidade.

Cada endpoint é associado a um método HTTP específico, como `GET`, `POST`, `PUT` e `DELETE`, que indica a operação que será realizada no recurso correspondente. Por exemplo, o método `GET` é comumente usado para recuperar informações, `POST` para criar novos recursos, `PUT` para atualizar recursos existentes e `DELETE` para remover recursos.

Agora, vamos dar uma olhada nos endpoints específicos que serão implementados em nossa API de gerenciamento de produtos:

| Método HTTP | Endpoint             | Descrição                                    |
| ----------- | -------------------- | -------------------------------------------- |
| `GET`       | `/api/produtos/all`  | Obtém uma lista de todos os produtos         |
| `GET`       | `/api/produtos/{id}` | Obtém detalhes de um produto específico      |
| `POST`      | `/api/produtos`      | Adiciona um novo produto ao sistema          |
| `PUT`       | `/api/produtos/{id}` | Atualiza os detalhes de um produto existente |
| `DELETE`    | `/api/produtos/{id}` | Remove um produto do sistema                 |

Estes são os endpoints básicos que vamos implementar em nossa API de gerenciamento de produtos. Cada endpoint realiza uma operação específica nos recursos de produto, permitindo que os clientes interajam com o sistema de acordo com suas necessidades.

# Contribuição

Sinta-se à vontade para abrir problemas (issues) ou enviar solicitações de recebimento (pull requests) para melhorar este projeto.
Leia o arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para saber detalhes sobre o nosso código de conduta e o processo de envio de solicitações _pull_ (_Pull Request_).

# Licença

Este projeto está licenciado sob a Licença MIT, consulte o arquivo [Licença MIT](LICENSE.md) para mais detalhes.
