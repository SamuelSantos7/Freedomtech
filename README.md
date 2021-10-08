
<h1 align=center>
<img src="https://i.imgur.com/Q7LG9zn.png" />
</h1>

<div align="center">



</div>

<h3 align="center">

📝 Uma rede social, focada no compartilhamento de temas educacionais e tecnologicos para incentivar e facilitar o acesso de novos estudantes, egressos do sistema prisional, ao mercado de trabalho.

</h3>



## **:rocket: OBJETIVO**




Uma pesquisa feita pelo Jus brasil, trouxe um questionamento sobre as razões pelas quais se acredita que egressos não regressam no mercado de trabalho e a resposta foi: 69,6% não conseguem oportunidades devido ao preconceito sofrido, 16,2% responderam que não possuem qualificações suficientes e 14,2% responderam que acredita que, o egresso se acostumou com a vida do crime.
Esses números nos incentivam a cada vez mais buscar a democratização do conhecimento, para que os dados apresentados fiquem para trás.

<!-- 
  ...
  Local Reservado para o GIF do projeto rodando.
  ...
-->

## FUNCIONALIDADES E PAGINAÇÃO:
### Cadastro de usuario
### Home
### Postagem
### Editar postagem
### Adicionar categorias
### Login 
### Sobre nós
### Timeline
### Atualize-se
### Playlist colaborativa


## **:computer: TECNOLOGIAS ULTILIZADAS**
![Java](https://img.shields.io/badge/-Java-000000?style=flat&logo=java)
![JavaScript](https://img.shields.io/badge/-JavaScript-000000?style=flat&logo=javascript)
![TypeScript](https://img.shields.io/badge/-TypeScript-000000?style=flat&logo=typescript)
![Git](https://img.shields.io/badge/-Git-222222?style=flat&logo=git&logoColor=F05032)
![GitHub](https://img.shields.io/badge/-GitHub-222222?style=flat&logo=github&logoColor=181717)
![Java Spring](https://img.shields.io/badge/-Spring-222222?style=flat&logo=spring&logoColor=6DB33F)
![MySQL](https://img.shields.io/badge/-MySQL-black?style=flat-square&logo=mysql)
![Bootstrap](https://img.shields.io/badge/-Bootstrap-563D7C?style=flat-square&logo=bootstrap)
![Angular](https://img.shields.io/badge/-Angular-DD0031?style=flat-square&logo=angular)
![CSS3](https://img.shields.io/badge/-CSS3-000000?style=flat&logo=css3)
![NodeJS](https://img.shields.io/badge/-NodeJS-DD0031?style=flat-square&logo=NodeJS)
  </a>
 
 

<div> 

 
  
 
</div>


## **:wine_glass: COMO UTILIZAR**

### Configurações Iniciais

No vs code para complilar a aplicação digite npm i para baixar as configurações necessarias e npm start para compilar ou ng serve 

```sh
# vs code:
$ npm install -g

# Expo (React Native):
$ npm install @angular/cli 
```

Você precisa renomear o arquivo `.env-example` para `.env` e inserir as informações que condizem com o seu **host**:

```sh
$ mv .env-example .env
```

Instale as dependências contidas nos arquivos `package.json` que se encontram na raíz do repositório (para o gerenciamento de commits), no diretório do **server**, no diretório do **website**  Para instalar as dependências, basta abrir o terminal no diretório e digitar o comando:

```sh
$ npm install

# ou
$ yarn
```

Exemplos:
```sh
# Instalando as dependências do commitlint:
$ cd ./ecoleta
$ npm install

# Instalando as dependências do server:
$ cd ./sources/server
$ npm install

# Instalando as dependências do website:
$ cd ./sources/website
$ npm install


Veja os arquivos **`package.json`** do <kbd>[commitlint](./package.json)</kbd>, <kbd>[server](./sources/server/package.json)</kbd>, <kbd>[website](./sources/website/package.json)</kbd> e <kbd>[mobile](./sources/mobile/package.json)</kbd>.

### Utilizando o Server

```sh
# Abrindo o terminal no diretório do servidor:
$ cd ./sources/server

# Executando a aplicação em modo de desenvolvimento:
$ npm run dev

# Instanciando o banco de dados:
$ npm run knex:migrate

# Povoando o banco de dados (seeds):
$ npm run knex:seed
```

> Veja a parte de **scripts {}** do arquivo <kbd>[package.json](./sources/server/package.json)</kbd> para saber quais scripts estão disponíveis.

### Utilizando o Website

```sh
# Abrindo o terminal no diretório do website:
$ cd ./sources/website

# Executando o website no modo de desenvolvimento:
$ npm run start
```

> Se o browser não abrir automaticamente, acesse: http://localhost:4200.



## **:octocat: COMO CONTRIBUIR**
  
  - Verifique as **[Issues](https://github.com/SamuelSantos7/Freedomtech)** que estão abertas e se já não existe alguma com a sua feature;
  - Abra uma **Issue** com o nome e descrição da sua feature e assine com o seu usuário informando que irá fazê-la;
  - Faça um **[fork](https://help.github.com/pt/github/getting-started-with-github/fork-a-repo)** do repositório;
  - Entre no sua página do GitHub e faça um **clone** do seu **fork**;
  - Crie uma *branch* com o nome da sua feature: `git chechout -b feat/minhaFeature`;
  - Faça as alterações necessárias no código ou na documentação;
  - Instale as dependências do *commitlint* na raíz do projeto para a verificação dos commits: `npm install` ou `yarn`;
  - Faça o *commit* das suas alterações seguindo as [convenções de commit](https://www.conventionalcommits.org/pt-br/v1.0.0-beta.4/), adicione na descrição o id da sua Issue em parênteses e lembre de fechar a sua Issue com o id no rodapé do commit:

  ```
    <tipo>(escopo opcional): <descrição> (#x)

    [corpo do commit]

    Close #x
  ```
  Exemplo:
  ```sh
    feat: adicionado componente para tal coisa (#52)

    Foi adicionado um componente para tal coisa com o objetivo de melhorar tal coisa, deixando o projeto de tal maneira.

    Close #52
  ```
  - Faça um *push* para a sua *branch*: `git push origin feat/minhaFeature`;
  - Agora é só abrir um *pull request* no repositório que você fez o *fork* e assim que acontecer o *merge* sua Issue será fechada e suas alterações irão fazer parte do projeto;
  - Depois que o *merge* da sua pull request for feito, você pode deletar a sua *branch*.

  \* **Obrigade por contribuir!** ❤️ :: :blush:

