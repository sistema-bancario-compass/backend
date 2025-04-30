# Sistema Bancário: Uma Aplicação Moderna em Spring Boot para Gestão de Transações Financeiras

Esta aplicação Spring Boot fornece um sistema bancário seguro e escalável que gerencia contas de clientes, processa transações financeiras e manipula dados dos clientes. O sistema oferece APIs RESTful para gerenciamento de contas, processamento de transações e operações com clientes, com foco em segurança e integridade dos dados.

A aplicação moderniza operações bancárias tradicionais ao fornecer uma arquitetura baseada em microsserviços que suporta funções bancárias básicas, incluindo criação de contas, transferências de fundos e gerenciamento de clientes. Ela utiliza Spring Security para o tratamento das requisições, PostgreSQL para persistência de dados e implementa uma arquitetura stateless para escalabilidade. O sistema foi projetado para lidar com múltiplos tipos de conta, manter histórico de transações e fornecer acesso seguro às operações bancárias por meio de endpoints REST.

## Estrutura do Repositório
```
banking-system/
├── src/                           # Diretório do código-fonte
│   ├── main/
│   │   ├── java/                 # Arquivos-fonte Java
│   │   │   └── uol/compass/hackathon/Banking/System/
│   │   │       ├── config/       # Classes de configuração de segurança e web
│   │   │       ├── controller/   # Controladores REST para contas, clientes e transações
│   │   │       ├── dto/          # Objetos de transferência de dados para respostas da API
│   │   │       ├── model/        # Modelos de domínio para Conta, Cliente e Transação
│   │   │       ├── repository/   # Interfaces de acesso a dados
│   │   │       └── service/      # Implementação da lógica de negócio
│   │   └── resources/
│   │       └── application.properties  # Configurações da aplicação
│   └── test/                     # Arquivos de teste
├── pom.xml                       # Configuração do projeto Maven
└── mvnw, mvnw.cmd               # Scripts do Maven Wrapper
```

## Instruções de Uso

### Pré-requisitos
- Java Development Kit (JDK) 21
- PostgreSQL 12 ou superior
- Maven 3.6 ou superior
- Spring Boot 3.4.5
- Porta 3000 disponível para a aplicação
- Porta 5432 disponível para o PostgreSQL

### Instalação

1. Clone o repositório:
```bash
git clone [repository-url]
cd banking-system
```

2. Configure o PostgreSQL:
```bash
# Crie o banco de dados
psql -U postgres
CREATE DATABASE projeto;
```

3. Atualize o arquivo `application.properties` com suas credenciais do banco de dados:
```properties
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
```

4. Compile e execute a aplicação:
```bash
./mvnw clean install
./mvnw spring-boot:run
```

### Início Rápido

1. Criar um novo cliente:
```bash
curl -X POST http://localhost:3000/api/customers \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","cpf":"12345678900"}'
```

2. Criar uma conta:
```bash
curl -X POST http://localhost:3000/api/accounts \
  -H "Content-Type: application/json" \
  -d '{"type":"CHECKING","balance":1000.00,"customerId":1}'
```

3. Realizar uma transação:
```bash
curl -X POST http://localhost:3000/api/transactions \
  -H "Content-Type: application/json" \
  -d '{"sourceAccountId":1,"amount":100.00,"type":"WITHDRAWAL"}'
```

### Exemplos Mais Detalhados

1. Obter contas de um cliente:
```bash
curl -X GET http://localhost:3000/api/accounts/customer/1
```

2. Obter histórico de transações:
```bash
curl -X GET http://localhost:3000/api/transactions
```

### Solução de Problemas

1. Problemas de Conexão com o Banco de Dados
- Erro: "Unable to connect to database"
  ```
  Verifique se o PostgreSQL está em execução:
  sudo service postgresql status

  Confirme as credenciais no application.properties
  ```

2. Problemas ao iniciar a aplicação
- Erro: "Port 3000 already in use"
  ```bash
  # Descubra o processo que está usando a porta 3000
  lsof -i :3000
  # Finalize o processo
  kill -9 <PID>
  ```

## Fluxo de Dados

O sistema bancário processa transações financeiras por meio de uma série de etapas validadas garantindo consistência e segurança dos dados.

```ascii
[Cliente] -> [Camada Controller]
              |
              v
[Camada Service (Lógica de Negócio)]
              |
              v
[Camada Repository] <-> [Banco de Dados PostgreSQL]
```

Interações entre componentes:
1. Os controladores recebem as requisições HTTP e validam os dados de entrada
2. Os serviços implementam a lógica de negócio e as regras de transação
3. Os repositórios lidam com a persistência dos dados
4. A camada de segurança valida todas as requisições recebidas
5. Os DTOs realizam a transferência de dados entre as camadas
6. Os modelos definem as entidades principais do domínio
7. O banco de dados mantém a consistência das transações por meio das propriedades ACID
