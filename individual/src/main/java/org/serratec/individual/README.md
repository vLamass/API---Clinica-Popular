# 🏥 API - Clínica Popular

## 📖 Descrição

API RESTful desenvolvida com Java e Spring Boot para gerenciamento de uma Clínica Popular.

O sistema permite o gerenciamento de:

- Pacientes
- Médicos
- Consultas
- Prontuários
- Especialidades médicas

O projeto foi desenvolvido aplicando conceitos de:

- Arquitetura em camadas
- Spring Data JPA
- Hibernate
- PostgreSQL
- DTOs
- Bean Validation
- Swagger/OpenAPI
- Tratamento global de exceções

---

# 🚀 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Bean Validation
- Lombok
- Git e GitHub

---

# 📁 Estrutura do Projeto

```bash
src/main/java
├── controller
├── service
├── repository
├── dto
├── entity
├── exception
└── config
```

---

# 🔗 Relacionamentos JPA

O projeto utiliza os principais relacionamentos do JPA:

| Relacionamento | Entidades |
|---|---|
| OneToOne | Paciente ↔ Prontuário |
| OneToMany | Paciente ↔ Consulta |
| OneToMany | Médico ↔ Consulta |
| ManyToMany | Médico ↔ Especialidade |

---

# 📌 Funcionalidades

✅ CRUD completo para todas as entidades

- GET
- GET BY ID
- POST
- PUT
- DELETE

✅ Validação de dados com Bean Validation

✅ Documentação com Swagger/OpenAPI

✅ Tratamento global de exceções

✅ DTOs Request e Response

✅ Persistência com PostgreSQL

---

# ▶️ Como Executar o Projeto

## ✅ Pré-requisitos

Antes de iniciar, é necessário ter instalado:

- Java 17
- PostgreSQL
- Maven

---

## 📥 Clonar o repositório

```bash
git clone https://github.com/vLamass/API---Clinica-Popular.git
```

---

## ⚙️ Configurar o banco de dados

No arquivo:

```bash
src/main/resources/application.properties
```

configure:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/clinica_popular
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

---

## ▶️ Executar o projeto

No terminal:

```bash
./mvnw spring-boot:run
```

Ou execute diretamente pela IDE.

---

# 📄 Documentação Swagger

Após iniciar a aplicação, a documentação estará disponível em:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

# 📌 Endpoints Principais

## 👤 Pacientes

| Método | Endpoint |
|---|---|
| GET | /pacientes |
| GET | /pacientes/{id} |
| POST | /pacientes |
| PUT | /pacientes/{id} |
| DELETE | /pacientes/{id} |

---

## 👨‍⚕️ Médicos

| Método | Endpoint |
|---|---|
| GET | /medicos |
| GET | /medicos/{id} |
| POST | /medicos |
| PUT | /medicos/{id} |
| DELETE | /medicos/{id} |

---

## 📅 Consultas

| Método | Endpoint |
|---|---|
| GET | /consultas |
| GET | /consultas/{id} |
| POST | /consultas |
| PUT | /consultas/{id} |
| DELETE | /consultas/{id} |

---

# 🧪 Exemplo de JSON

## 📥 Cadastro de Paciente

```json
{
  "nome": "João Silva",
  "cpf": "12345678900",
  "email": "joao@email.com",
  "dataNascimento": "1995-05-10"
}
```

---

# ⚠️ Tratamento de Exceções

A API possui tratamento global de exceções utilizando:

- @ControllerAdvice
- Exceptions customizadas
- Respostas padronizadas

Status tratados:

| Status | Descrição |
|---|---|
| 400 | Dados inválidos |
| 404 | Recurso não encontrado |
| 409 | Conflito de dados |

---

# 👨‍💻 Autor

Projeto desenvolvido por Vinicius Lamas como trabalho individual da disciplina de API REST.
