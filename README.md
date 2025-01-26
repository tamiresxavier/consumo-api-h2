# ✨ Spring Boot App: Consumo de API ViaCEP com H2 e Feign ✨

Uma solução elegante e moderna para consumir a API [ViaCEP](https://viacep.com.br), armazenar os resultados em um banco de dados H2 e expor endpoints REST para consulta de CEPs.

---

## 🔧 **Recursos Principais**

- ⭐ Consumo simplificado da API ViaCEP usando **Feign**.
- 📊 Banco de dados em memória **H2** com console web habilitado.
- 🌐 Endpoints REST para consultas fáceis e rápidas.

---

## ⚙️ **Tecnologias Utilizadas**

- **Java 17**
- **Spring Boot 3.x**  
  - Spring Web
  - Spring Data JPA
  - Spring Cloud OpenFeign
- **Banco de Dados H2**
- **Maven**

---

## 🚀 **Como Executar o Projeto**

### 1. Clone o Repositório
```bash
git clone https://github.com/tamiresxavier/consumo-api-h2.git
cd seu-repositorio
```

### 2. Compile e Execute a Aplicação
```bash
mvn spring-boot:run
```

### 3. Acesse a Aplicação
- Endpoint principal: `http://localhost:8080/consulta-cep?cep=01001000`
- Console H2: `http://localhost:8080/h2-console`

---

## 🔄 **Endpoints Disponíveis**

### **Consulta de CEP**
- **URL:** `http://localhost:8080/consulta-cep`
- **Método:** `GET`
- **Parâmetro:** `cep` (CEP apenas com números)

#### Exemplo de Requisição:
```bash
curl -X GET 'http://localhost:8080/consulta-cep?cep=01001000'
```

#### Exemplo de Resposta:
```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

---

## 🏛️ **Acessando o Banco de Dados H2**

1. **URL do Console H2:** `http://localhost:8080/h2-console`
2. **Credenciais:**
   - **JDBC URL:** `jdbc:h2:mem:mydb`
   - **Usuário:** `admin`
   - **Senha:** `password`

#### Exemplo de Consulta SQL:
```sql
SELECT * FROM ENDERECO;
```

---

## 🛠️ **Estrutura do Projeto**

```
src/main/java/com/accenture/consumo
├── ConsumoApplication.java       # Classe principal
├── controller
│   └── CepRestController.java    # Controlador REST
├── interfaces
│   └── CepService.java           # Interface Feign
├── model
│   └── Endereco.java             # Entidade Endereco
└── repository
    └── EnderecoRepository.java   # Repositório JPA
```

---

## 💡 **Configurações Essenciais**

### **Dependências (pom.xml)**

```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Spring Cloud OpenFeign -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>

    <!-- Banco de Dados H2 -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

### **Propriedades (application.properties)**

```properties
# Configurações do Banco H2
spring.datasource.url=jdbc:h2:mem:mydb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=admin
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Habilitar Console do H2
spring.h2.console.enabled=true
```

---
