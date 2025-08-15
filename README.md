# Projeto-gerenciamento-contatos-api
API RESTful para gerenciamento de contatos, desenvolvida em Java com Spring Boot e PostgreSQL.  Permite criar, atualizar, listar e excluir contatos, com hospedagem no Railway.

## 🔧 Tecnologias

- Java 21
- Spring Boot
- JPA
- PostgreSQL
- Swagger
- Deploy: Visual Studio Code + Railway

## 📌 Endpoints

- `GET /contato` — Listar todos os contatos
- `POST /contato` — Cadastrar novo contato
- `PUT /contato/{id}` — Atualizar contato completo
- `PATCH /contato/{id}` — Atualizar contato parcialmente
- `DELETE /contato/{id}` — Excluir contato

## 📍 Como Rodar

```bash

# Clone o repositório
git clone https://github.com/GuilhermeLucera/projeto-gerenciamento-contatos-api

# Entre no diretório
cd projeto-gerenciamento-contatos-api

# Instale as dependências e compile
mvn clean install

# Executar localmente
mvn spring-boot:run

```
[Guilherme Lucera / [LinkedIn](https://www.linkedin.com/in/guilherme-lucera-49997b213/)]
