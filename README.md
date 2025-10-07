# 📀 Projeto Locadora de DVDs v1.0

Este projeto é uma aplicação web completa desenvolvida em Java para o gerenciamento de uma locadora de DVDs. O sistema foi construído como parte de um processo de aprendizado focado, aplicando os conceitos da arquitetura MVC (Model-View-Controller) com Servlets e JSPs.

**Status do Projeto:** Concluído ✔️

## ✨ Funcionalidades

O sistema implementa as operações de CRUD (Criar, Ler, Atualizar e Excluir) para as seguintes entidades:

* [x] **Gêneros:** Cadastro completo de gêneros de filmes.
* [x] **Classificações Etárias:** Cadastro completo de classificações indicativas.
* [x] **Atores:** Cadastro completo de atores e atrizes.
* [x] **DVDs:** Cadastro completo de DVDs, relacionando-os com as outras entidades.

## 🎨 Design e Estilização

A interface da aplicação foi desenvolvida com um tema escuro (Dark Mode) e modularizada com CSS para garantir uma experiência de usuário agradável e consistente.

* **Tema Principal:** Paleta de cores escura com Roxo e Ciano como cores de destaque.
* **Estilos Modulares:** Um arquivo `estilo.css` principal para a base, um `pagina.css` para a estrutura, e arquivos específicos (`ator.css`, `genero.css`, etc.) para customizar cada seção.
* **Ícones:** Utilização da biblioteca Font Awesome para melhorar a usabilidade da interface.
* **Animações:** Efeitos sutis de transição e entrada para uma navegação mais fluida.

## 🚀 Tecnologias Utilizadas

#### Backend
* **Java 17 (LTS)**
* **Jakarta Servlets**: Para o controle das requisições (Controller).
* **JDBC (Java Database Connectivity)**: Para a comunicação com o banco de dados.
* **MariaDB / MySQL**: Como sistema de gerenciamento de banco de dados.

#### Frontend
* **JSP (Jakarta Server Pages)**: Para a criação das páginas dinâmicas (View).
* **JSTL (Jakarta Standard Tag Library)**: Para adicionar lógica às páginas JSP de forma limpa.
* **HTML5** e **CSS3**

#### Ferramentas e Ambiente
* **IDE:** Apache NetBeans
* **Servidor de Aplicação:** Eclipse GlassFish / Payara
* **Banco de Dados:** MySQL Workbench
* **Controle de Versão:** Git e GitHub

## 🏛️ Arquitetura

O projeto segue a arquitetura **MVC (Model-View-Controller)**, padrão Model 2 para Java Web:

* **Model:** As classes de entidade no pacote `locacaodvds.entidades` (`DVD.java`, `Ator.java`, etc.).
* **View:** As páginas JSP localizadas em `Web Pages/formulario/`, responsáveis pela apresentação dos dados.
* **Controller:** Os Servlets no pacote `locacaodvds.controladores`, que recebem as requisições, processam a lógica e decidem qual view exibir.

Além disso, a arquitetura foi dividida em camadas para melhor organização:
* **Camada de DAO (Data Access Object):** Responsável pela comunicação direta com o banco de dados.
* **Camada de Serviços (Services):** Atua como uma ponte entre os Servlets e os DAOs.

## ⚙️ Como Executar o Projeto

Siga os passos abaixo para configurar e rodar a aplicação localmente.

#### Pré-requisitos
* JDK 17 ou superior (LTS recomendado).
* Apache NetBeans IDE.
* Um servidor de aplicação compatível (GlassFish ou Payara) configurado no NetBeans.
* Servidor de banco de dados MariaDB ou MySQL.
* MySQL Workbench.

#### 1. Configuração do Banco de Dados
1.  Abra o MySQL Workbench.
2.  Execute o script SQL do modelo (`.mwb`) fornecido pelo material do curso para criar o banco de dados `locacao_dvds` e todas as suas tabelas.
3.  Certifique-se de que o banco de dados foi criado com sucesso.

#### 2. Configuração do Projeto
1.  Clone este repositório: `git clone https://github.com/GabsCavalcant/Projeto_LocacaoDvd.git`
2.  Abra o projeto no NetBeans.
3.  Navegue até o arquivo `locacaodvds.jdbc.ConnectionFactory.java`.
4.  Altere a URL de conexão, o usuário e a senha para corresponder às configurações do seu banco de dados local:
    ```java
    String url = "jdbc:mariadb://localhost:3306/locacao_dvds";
    String user = "seu_usuario"; // geralmente "root"
    String password = "sua_senha";
    ```
5.  Clique com o botão direito no projeto e selecione **"Limpar e Construir" (Clean and Build)**.

#### 3. Execução
1.  Clique com o botão direito no projeto.
2.  Selecione **"Executar" (Run)**.
3.  O NetBeans irá implantar a aplicação no seu servidor e abrir a página `index.jsp` no navegador.

## 👨‍💻 Autor

* **Gabriel Cavalcante** - [GabsCavalcant](https://github.com/GabsCavalcant)

---
*Este projeto foi desenvolvido com a assistência e mentoria do Gemini, em um processo focado no aprendizado prático e na resolução de problemas.*
