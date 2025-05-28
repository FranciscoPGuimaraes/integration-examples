# Integração com MySQL em Python, Java e Node.js

Este repositório demonstra como integrar um sistema com o MySQL localmente usando três linguagens diferentes:

- **Python**
- **Java**
- **Node.js (JavaScript)**

Cada projeto realiza operações básicas (CRUD) em uma tabela `alunos`.

---

## 📁 Estrutura do Repositório

```
.
├── python_project/
├── java_project/
└── node_project/
```

---

## 🐍 Python

### 📍 Requisitos

- Python 3.10+
- MySQL instalado e rodando localmente
- Biblioteca `mysql-connector-python`

### 📦 Instalação

1. Acesse a pasta do projeto:

   ```bash
   cd python_project
   ```

2. Crie um ambiente virtual:

   ```bash
   python -m venv .venv
   ```

3. Ative o ambiente virtual:

   - Windows:
     ```bash
     .venv\Scripts\activate
     ```
   - Linux/Mac:
     ```bash
     source .venv/bin/activate
     ```

4. Instale as dependências:

   ```bash
   pip install mysql-connector-python
   ```

### ▶️ Executar

```bash
python main.py
```

---

## ☕ Java

### 📍 Requisitos

- JDK 17+
- MySQL instalado e rodando localmente
- MySQL Connector/J (`mysql-connector-java-x.x.xx.jar`)
- IDE como IntelliJ, Eclipse, ou compilador de linha de comando

### 📦 Instalação

Recomendo fortemente que utilize o material dos slides para realizar este procedimento de instalação. (Material mais completo e simples)

1. Baixe o driver JDBC do MySQL em:  
   https://dev.mysql.com/downloads/connector/j/

2. Importe o `.jar` no projeto via sua IDE ou usando linha de comando.

### ▶️ Compilar e Executar via Terminal

```bash
cd java_project/src
javac -cp ".;../lib/mysql-connector-java-<version>.jar" Main.java database/ConnectionFactory.java models/Aluno.java
java -cp ".;../lib/mysql-connector-java-<version>.jar" Main
```

Substitua `<version>` pela versão correta do seu JAR.

---

## 🌐 Node.js

### 📍 Requisitos

- Node.js 18+
- MySQL instalado e rodando localmente

### 📦 Instalação

1. Acesse a pasta:

   ```bash
   cd node_project
   ```

2. Instale as dependências:

   ```bash
   npm install
   ```

### ▶️ Executar

```bash
node main.js
```

---

## 🗃️ Estrutura da Tabela MySQL

Crie o banco e a tabela `alunos` antes de rodar qualquer projeto:

```sql
CREATE DATABASE escola;

USE escola;

CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    matricula VARCHAR(50),
    email VARCHAR(100)
);
```

---

## 📌 Observações

- Todos os projetos utilizam o usuário `root` com senha `root` para o MySQL. Altere nos arquivos se necessário.
- O CRUD inclui: criação, listagem, busca por ID e remoção de alunos.
- Os três exemplos seguem uma estrutura semelhante, com separação entre conexão, modelos e lógica principal.
