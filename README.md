# 🏦 Banking System (Refatoração COBOL)

Este projeto é uma refatoração moderna de um sistema bancário originalmente implementado em COBOL. Utiliza **Spring Boot 3.4.5**, Java 21, e segue as boas práticas de desenvolvimento backend com segurança e estruturação em camadas.

---

## 📦 Tecnologias e Ferramentas

- Java 21
- Spring Boot 3.4.5
- Spring Security
- Maven
- RESTful API

---

## 📁 Estrutura do Projeto

```
backend-main/
├── src/
│   └── main/
│       ├── java/uol/compass/hackathon/Banking/System/
│       │   ├── config/              # Configurações de segurança
│       │   ├── controller/          # Endpoints da API REST
│       │   ├── dto/                 # Objetos de Transferência de Dados
│       │   ├── model/               # Entidades JPA
│       │   └── BankingSystemApplication.java
│       └── resources/
├── pom.xml                          # Gerenciador de dependências Maven
└── README.md
```

---

## 🚀 Como Executar

### Pré-requisitos

- [Java 21+](https://adoptium.net)
- [Maven 3+](https://maven.apache.org/)

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/backend-main.git
cd backend-main

# Compile e rode a aplicação
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
📍 `http://localhost:8080`

---

## 🔐 Segurança

O projeto utiliza `Spring Security` para autenticação e autorização. Verifique o arquivo `SecurityConfig.java` para ajustes nas regras de acesso.

---

## 🧪 Endpoints REST

Alguns exemplos de endpoints (verifique `controller/` para mais):

| Método | Endpoint                 | Descrição                   |
|--------|--------------------------|------------------------------|
| GET    | `/clients`               | Lista todos os clientes     |
| POST   | `/accounts`              | Cria uma conta bancária     |
| POST   | `/transactions/transfer` | Realiza uma transferência   |

---

## 👥 Contribuidores

Projeto desenvolvido durante o **Hackathon UOL Compass**.

---

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).
