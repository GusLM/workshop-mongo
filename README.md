<h1 align="center">🍃 workshop-mongo</h1>

<p align="center">
API REST de estudo com <strong>Spring Boot 4</strong> + <strong>MongoDB</strong><br/>
Operações CRUD com banco NoSQL orientado a documentos
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-blue" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4-green" />
  <img src="https://img.shields.io/badge/MongoDB-NoSQL-brightgreen" />
  <img src="https://img.shields.io/badge/Maven-Build-red" />
</p>

---

<h2>📖 Sobre o Projeto</h2>

<p>
O <strong>workshop-mongo</strong> é um projeto de estudo que demonstra a integração entre 
<strong>Spring Boot</strong> e <strong>MongoDB</strong> utilizando o Spring Data MongoDB.
</p>

<p>
O objetivo é servir como referência prática para construção de APIs REST com banco NoSQL,
abordando mapeamento de documentos, queries e organização em camadas.
</p>

<blockquote>
Projeto educacional — sem foco em produção. Sinta-se livre para estudar e adaptar.
</blockquote>

---

<h2>🛠️ Stack Tecnológica</h2>

<ul>
  <li><strong>Java 25</strong></li>
  <li><strong>Spring Boot 4</strong></li>
  <li><strong>MongoDB</strong></li>
  <li><strong>Spring Data MongoDB</strong></li>
  <li><strong>Maven</strong></li>
  <li><strong>Spring Web MVC</strong></li>
</ul>

---

<h2>📁 Estrutura do Projeto</h2>

<pre>
workshop-mongo/
├── .mvn/wrapper/
├── src/
│   ├── main/java/com/gustavosantos/workshopmongo/
│   │   ├── config/
│   │   ├── domain/
│   │   ├── dto/
│   │   ├── repository/
│   │   ├── resources/
│   │   ├── services/
│   │   └── WorkshopMongoApplication.java
│   └── main/resources/
│       └── application.properties
├── test/
├── pom.xml
</pre>

---

<h2>✅ Pré-requisitos</h2>

<ul>
  <li>JDK 25+</li>
  <li>MongoDB rodando na porta 27017</li>
  <li>Maven 3.8+ ou wrapper</li>
  <li>Git</li>
  <li>(Opcional) MongoDB Compass</li>
  <li>(Opcional) Postman / Insomnia</li>
</ul>

---

<h2>🚀 Como Executar</h2>

<ol>
  <li>
    <strong>Clonar repositório</strong>
<pre><code>git clone https://github.com/GusLM/workshop-mongo.git
cd workshop-mongo</code></pre>
  </li>

  <li>
    <strong>Iniciar MongoDB</strong>
<pre><code># Linux/macOS
mongod

# Windows
net start MongoDB</code></pre>
  </li>

  <li>
    <strong>Configurar conexão</strong>
<pre><code>spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=workshopmongo</code></pre>
  </li>

  <li>
    <strong>Executar aplicação</strong>
<pre><code>./mvnw spring-boot:run</code></pre>
  </li>

  <li>
    <strong>Acessar API</strong><br/>
    http://localhost:8080
  </li>
</ol>

---

<h2>🔌 Endpoints</h2>

<h3>👤 Users</h3>

<table>
<tr><th>Método</th><th>Rota</th><th>Descrição</th></tr>
<tr><td>GET</td><td>/users</td><td>Listar usuários</td></tr>
<tr><td>GET</td><td>/users/{id}</td><td>Buscar por ID</td></tr>
<tr><td>POST</td><td>/users</td><td>Criar usuário</td></tr>
<tr><td>PUT</td><td>/users/{id}</td><td>Atualizar</td></tr>
<tr><td>DELETE</td><td>/users/{id}</td><td>Remover</td></tr>
</table>

<h3>📝 Posts</h3>

<table>
<tr><th>Método</th><th>Rota</th><th>Descrição</th></tr>
<tr><td>GET</td><td>/posts/{id}</td><td>Buscar post</td></tr>
<tr><td>GET</td><td>/posts/titlesearch?text=</td><td>Buscar por título</td></tr>
<tr><td>GET</td><td>/posts/search</td><td>Busca avançada</td></tr>
</table>

---

<h2>📚 Conceitos Demonstrados</h2>

<ul>
  <li>Mapeamento com <code>@Document</code></li>
  <li>MongoRepository</li>
  <li>Referências vs Embedding</li>
  <li>Queries personalizadas</li>
  <li>DTOs</li>
  <li>Camada de serviço</li>
  <li>Tratamento de exceções</li>
</ul>

---

<h2>📦 Dependências</h2>

<pre><code>&lt;dependency&gt;
  &lt;artifactId&gt;spring-boot-starter-data-mongodb&lt;/artifactId&gt;
&lt;/dependency&gt;

&lt;dependency&gt;
  &lt;artifactId&gt;spring-boot-starter-webmvc&lt;/artifactId&gt;
&lt;/dependency&gt;
</code></pre>

---

<h2>🧪 Testes</h2>

<pre><code>./mvnw test</code></pre>

---

<h2>👤 Autor</h2>

<p>
<a href="https://github.com/GusLM"><strong>GusLM</strong></a><br/>
Gustavo Santos
</p>

---

<p align="center">
Feito com ☕ Java + 🍃 MongoDB
</p>
