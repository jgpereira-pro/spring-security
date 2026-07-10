# 🔒 Spring Security & JWT Authentication API

## 💻 Sobre o Projeto
Esta é uma API RESTful desenvolvida em **Java com Spring Boot** com o foco exclusivo em implementar um sistema robusto de Autenticação e Autorização. O projeto atua como um provedor de identidade, garantindo que apenas usuários autenticados e com os privilégios corretos possam acessar recursos protegidos.

A segurança da aplicação foi construída utilizando o **Spring Security** em conjunto com **JSON Web Tokens (JWT)**, garantindo uma arquitetura *Stateless* (sem estado), ideal para microsserviços e aplicações modernas onde o frontend (React, Angular, Mobile) armazena o token e o envia a cada requisição.

## 🚀 Tecnologias Utilizadas
* **Java** - Linguagem principal do projeto.
* **Spring Boot** - Framework para inicialização e configuração ágil.
* **Spring Security** - Módulo de segurança para controle de acesso, filtros de requisição e criptografia de senhas.
* **JWT (JSON Web Token)** - Padrão da indústria para transmissão compacta e segura de informações entre partes como um objeto JSON.
* **Spring Data JPA** - Para persistência dos usuários e perfis de acesso no banco de dados.

## 🛠️ Funcionalidades
* **Cadastro de Usuários:** Endpoint aberto para registro de novos usuários na plataforma (`CreateUserDto`).
* **Login e Geração de Token:** Autenticação validando credenciais no banco de dados e emitindo um Token JWT assinado (`LoginUserDto`, `RecoveryJwtTokenDto`).
* **Criptografia de Senhas:** As senhas nunca são salvas em texto plano, utilizando *Hashing* forte (ex: BCrypt) antes de persistir no banco.
* **Controle de Acesso Baseado em Roles (RBAC):** Uso de entidades `Role` e `RoleName` para diferenciar permissões (ex: ROLE_USER, ROLE_ADMIN).
* **Filtro de Interceptação:** O `UserAuthenticationFilter` intercepta requisições HTTP, extrai o token do cabeçalho `Authorization` e valida a identidade do usuário antes de liberar a rota.

## ⚙️ Arquitetura e Estrutura de Pastas
O projeto isola muito bem a complexidade da segurança da regra de negócio padrão:

* `/config`: Onde a mágica acontece. Contém o `SecurityConfiguration` (desabilitando CSRF e configurando a política *Stateless*) e o filtro customizado `UserAuthenticationFilter`.
* `/service`: Implementa os contratos do Spring Security. O `UserDetailsServiceImpl` e o `UserDetailsImpl` ensinam o Spring a como buscar e entender o "Usuário" do seu domínio. O `JwtTokenService` isola a lógica de criação e validação de tokens.
* `/entity` e `/repository`: Mapeamento do usuário e suas permissões para o banco de dados.
* `/Dto`: Objetos de transferência de dados garantindo que entidades sensíveis não sejam expostas nas requisições e respostas.

## 🏁 Como Executar o Projeto

**Pré-requisitos:** [Java Development Kit (JDK 17+)](https://adoptium.net/) instalado.

1.Clone o repositório:

git clone [https://github.com/SEU-USUARIO/](https://github.com/SEU-USUARIO/)[NOME-DO-REPOSITORIO].git

2.Acesse a pasta do projeto:

cd [NOME-DO-REPOSITORIO]

3.Execute a aplicação utilizando o Maven Wrapper:

No Linux/macOS:
./mvnw spring-boot:run

No Windows:
mvnw.cmd spring-boot:run
