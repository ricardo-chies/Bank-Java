# BANK_JAVA

# Descrição
Este projeto consiste em uma API para disponibilizar endpoints para consumo em uma aplicação web.<br>

# Detalhes da Aplicação:
<ul>
  <li>Java 17</li>
  <li>Spring Boot 3</li>
  <li>Clean Arquitecture</li>
  <li>Padrão DTO via Java Records</li>
  <li>Mapeamento de entidade JPA com interface repository</li>
  <li>Conexão com banco de dados MySql</li>
  <li>Flyway como ferramenta de migrations.</li>
  <li>Validações com Bean Validation.</li>
  <li>Configuração CORS</li>
  <li>Princípios SOLID.</li>
</ul>
  
## EndPoints:
<ul>
  <li>POST - Cadastrar cliente</li>
  <li>POST - Login cliente</li>
  <li>GET - Listar clientes</li>
  <li>PUT - Atualizar cadastro cliente</li>
  <li>POST - Cadastrar conta</li>
  <li>GET - Listar contas</li>
  <li>GET - Buscar conta cliente</li>
  <li>GET - Extrato cliente</li>
  <li>PUT - Inativar conta</li>
  <li>DELETE - Excluir conta</li>
  <li>POST - Realizar movimentação</li>
  <li>GET - Listar Movimentações</li>
</ul>

# Instruções para Configurar e Executar a Aplicação

Este guia fornece um passo a passo para preparar o ambiente, importar o projeto e executar a aplicação no IntelliJ IDEA usando Java 17.

## Pré-requisitos

1. **Instalar o JDK 17 (Java Development Kit)**
   - Baixe e instale o JDK 17.
   - [Download do JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
   - Configure a variável de ambiente `JAVA_HOME`.

2. **Instalar o Maven**
   - [Download do Maven](https://maven.apache.org/download.cgi)
   - Configure a variável de ambiente `MAVEN_HOME` e adicione o caminho `bin` do Maven ao `PATH`.

3. **Instalar IntelliJ IDEA**
   - Baixe e instale a versão Community ou Ultimate do IntelliJ IDEA.
   - [Download do IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
  
4. **Instalar e Configurar o MySQL**
   - Baixe e instale o MySQL.
   - [Download do MySQL](https://dev.mysql.com/downloads/)
   - Crie um banco de dados para a aplicação:
     ```sql
     CREATE DATABASE bank_java;
     ```
   - Neste projeto está configurado as migrations utilizando Flyway, que irá realizar a criação das tabelas do banco de dados.
   - Configure o arquivo resources\application.properties com as informações de seu usuário e senha do MySql.
     ```
      spring.datasource.username={nome_usuario}
      spring.datasource.password={senha}
     ```

## Passo 1: Clonar o Repositório do GitHub

1. Abra o terminal ou o prompt de comando.
2. Navegue até o diretório onde deseja clonar o repositório.
3. Execute o comando para clonar o repositório:

## Passo 2: Importar o Projeto no IntelliJ IDEA
1. Abra o IntelliJ IDEA.
2. No menu de boas-vindas, selecione Open ou Import Project.
3. Navegue até o diretório do projeto clonado e selecione o arquivo pom.xml.
4. Selecione Open as Project.
O IntelliJ IDEA irá detectar o projeto como um projeto Maven e começará a importar as dependências e configurações do projeto. Isso pode levar alguns minutos.

## Passo 3: Configurar o JDK 17 no IntelliJ IDEA
1. Abra as configurações do projeto:
File > Project Structure > Project
2. Certifique-se de que o Project SDK está configurado para a versão correta do JDK (Java 17). Se não estiver configurado, clique em New... e selecione o caminho do JDK instalado.

## Passo 4: Configurar o Maven no IntelliJ IDEA
1. Abra as configurações do Maven:
File > Settings (ou Ctrl+Alt+S) > Build, Execution, Deployment > Build Tools > Maven
2. Certifique-se de que o Maven home directory está configurado corretamente (deveria ser detectado automaticamente pelo IntelliJ IDEA).

## Passo 5: Construir e Executar a Aplicação
1. No painel do lado direito, você deve ver a aba Maven. Expanda-a e navegue até Lifecycle.
2. Clique duas vezes em clean e depois em install para construir o projeto.
Isso irá compilar o código e baixar todas as dependências necessárias.

## Passo 6: Executar a Aplicação
1. Navegue até a classe principal que contém o método main (no seu caso, ApiApplication).
2. Clique com o botão direito do mouse na classe e selecione Run 'ApiApplication.main()'.
O IntelliJ IDEA irá compilar e iniciar a aplicação. Você deve ver a saída do console indicando que o Spring Boot iniciou corretamente.

## Passo 7: Verificar o Funcionamento da Aplicação
1. Abra um navegador web ou uma ferramenta de API como Postman.
2. Acesse os endpoints da sua aplicação para verificar se está funcionando corretamente, por exemplo:
http://localhost:8080/clientes/login
Pronto! Agora você deve ter a aplicação configurada e rodando no IntelliJ IDEA.

# Autor
José Ricardo Chies Gonçalves

LinkedIn:
https://www.linkedin.com/in/ricardo-chies-087557216/

E-mail:
chies.dev@gmail.com
