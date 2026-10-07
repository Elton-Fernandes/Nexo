Nexo — Sistema de Gestão para Pequenos Negócios

API REST para centralizar e gerenciar operações de pequenos negócios, incluindo produtos, estoque, clientes, fornecedores e vendas.










📌 Sobre o projeto

O Nexo é um sistema de gestão desenvolvido para pequenos negócios que precisam centralizar suas operações em uma única aplicação.

A proposta é controlar informações de produtos, estoque, clientes, fornecedores e vendas, além de transformar os dados registrados em informações úteis para acompanhamento e tomada de decisão.

O projeto não tem como objetivo ser apenas uma coleção de operações CRUD. A aplicação está sendo construída com foco em regras de negócio e situações encontradas em um comércio real, como controle de estoque, cancelamento de vendas, devoluções, controle de caixa, alertas e análise do desempenho dos produtos.

A motivação surgiu da necessidade de pequenos comerciantes que atualmente podem utilizar planilhas, anotações ou diferentes sistemas para controlar partes da operação, dificultando a obtenção de uma visão centralizada do negócio.

✨ Funcionalidades
Produtos
Cadastro de produtos
Edição e consulta
Organização por categorias
Controle de preço de custo e preço de venda
Controle da situação do produto
Definição de estoque mínimo
Estoque
Controle de quantidade
Entradas e saídas
Ajustes de estoque
Histórico de movimentações
Alertas para produtos abaixo do estoque mínimo
Vendas
Criação de vendas
Associação de produtos às vendas
Controle de quantidade e preço praticado
Cálculo de subtotais e totais
Aplicação de descontos
Cancelamento de vendas
Devolução dos itens ao estoque quando aplicável
Clientes
Cadastro de clientes
Consulta de informações
Histórico de compras
Fornecedores
Cadastro de fornecedores
Relacionamento entre fornecedores e produtos
Controle da origem dos produtos
Caixa
Abertura de caixa
Registro de movimentações
Fechamento de caixa
Acompanhamento financeiro básico
Gestão
Indicadores de vendas
Ticket médio
Produtos mais vendidos
Alertas de estoque
Relatórios de vendas e estoque
Usuários
Autenticação
Autorização
Controle de permissões conforme o perfil do usuário

Algumas funcionalidades fazem parte do planejamento e serão implementadas progressivamente conforme o roadmap do projeto.

🛠️ Tecnologias utilizadas
Java
Spring Boot
Spring Data JPA
Spring Security
PostgreSQL
Docker
Bean Validation
JUnit
Mockito
OpenAPI / Swagger

A arquitetura planejada utiliza uma estrutura em camadas:

Cliente
   ↓
REST Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL

O projeto segue inicialmente uma abordagem de monólito modular, buscando manter uma separação clara entre responsabilidades.

📋 Pré-requisitos

Antes de executar o projeto, tenha instalado:

JDK 21 ou versão compatível com o projeto
Maven ou Maven Wrapper
Docker
Docker Compose, caso seja utilizado no ambiente local
PostgreSQL, caso o banco não seja executado através do Docker

Verifique as instalações:

java -version
mvn -version
docker --version
🚀 Instalação e execução
1. Clone o repositório
git clone [PREENCHER: URL DO REPOSITÓRIO]

Entre no diretório:

cd nexo
2. Configure o banco de dados

O projeto utiliza PostgreSQL como banco de dados.

Caso o banco seja executado através do Docker, configure o ambiente conforme o arquivo de infraestrutura disponível no projeto.

[PREENCHER: comando para inicialização do PostgreSQL/Docker]
3. Execute a aplicação

Com Maven Wrapper:

Linux/macOS
./mvnw spring-boot:run
Windows
mvnw.cmd spring-boot:run

Ou utilizando o Maven instalado:

mvn spring-boot:run

Após a inicialização, a API estará disponível em:

http://localhost:8080

A porta pode ser alterada através da configuração da aplicação.

⚙️ Configuração

As configurações de conexão com o banco de dados devem ser definidas no arquivo de configuração do Spring Boot ou através de variáveis de ambiente.

Exemplo:

spring.datasource.url=jdbc:postgresql://localhost:5432/[NOME_DO_BANCO]
spring.datasource.username=[USUARIO]
spring.datasource.password=[SENHA]

spring.jpa.hibernate.ddl-auto=[CONFIGURACAO]
Variáveis de ambiente

Caso o projeto utilize variáveis de ambiente:

DB_HOST=localhost
DB_PORT=5432
DB_NAME=[NOME_DO_BANCO]
DB_USERNAME=[USUARIO]
DB_PASSWORD=[SENHA]

Os nomes definitivos das variáveis devem corresponder à configuração utilizada atualmente pelo projeto.

📖 Exemplos de uso
Criar uma venda

Exemplo conceitual de requisição:

POST /vendas
Content-Type: application/json
{
  "idCliente": 1,
  "desconto": 0,
  "itens": [
    {
      "idProduto": 1,
      "quantidade": 2
    }
  ]
}

[PREENCHER: ajustar o exemplo conforme o VendaRequestDTO definitivo.]

Consultar vendas
GET /vendas
Documentação da API

A API poderá disponibilizar sua documentação através do OpenAPI/Swagger.

http://localhost:8080/swagger-ui/index.html
Capturas de tela

[PREENCHER: adicionar imagens do Swagger, sistema de vendas, dashboard ou demais telas quando disponíveis.]

docs/images/swagger.png
📁 Estrutura do projeto

Estrutura resumida prevista para o backend:

nexo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── eltonfernandesdev/
│   │   │           └── nexo/
│   │   │               ├── controller/
│   │   │               ├── dto/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               ├── service/
│   │   │               └── validation/
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
Principais responsabilidades
Pacote	Responsabilidade
controller	Receber requisições HTTP e retornar respostas da API
dto	Representar dados de entrada e saída da API
model	Representar as entidades do domínio
repository	Acesso e persistência dos dados
service	Implementar regras de negócio
validation	Validações específicas do domínio
test	Testes automatizados
🧪 Testes

Os testes automatizados são executados utilizando Maven:

./mvnw test

No Windows:

mvnw.cmd test

Ou, caso o Maven esteja instalado:

mvn test

O projeto utiliza JUnit e Mockito para testes automatizados. A etapa de qualidade também prevê tratamento global de erros, validações e documentação da API.

🗺️ Roadmap

O desenvolvimento do Nexo está organizado em etapas:

 Definição inicial dos requisitos
 Modelagem inicial do domínio
 Estrutura inicial da aplicação Spring Boot
 Configuração inicial do banco PostgreSQL
 Implementação inicial de produtos e categorias
 Implementação inicial de clientes e fornecedores
 Implementação inicial de vendas e itens de venda
 Regras completas de movimentação de estoque
 Cancelamento e devolução de vendas
 Controle de caixa
 Dashboard
 Relatórios
 Autenticação e autorização
 Testes automatizados abrangentes
 Tratamento global de erros
 Documentação completa da API
 Dockerização completa
 CI/CD
 Preparação para deploy

A evolução planejada segue as fases de fundação, operação, vendas, gestão, segurança, qualidade e deploy.

🤝 Como contribuir

O projeto encontra-se em desenvolvimento. Para contribuir:

Faça um fork do projeto.
Crie uma branch para sua alteração:
git checkout -b feature/minha-alteracao
Implemente e teste as alterações.
Faça o commit:
git commit -m "feat: descreve a alteração"
Envie a branch:
git push origin feature/minha-alteracao
Abra um Pull Request descrevendo as alterações realizadas.
📄 Licença

Este projeto atualmente não possui uma licença definida.

[PREENCHER: adicionar licença, por exemplo MIT, caso uma licença seja escolhida.]

👤 Autor

[PREENCHER: nome do autor]

GitHub: [PREENCHER: link do GitHub]
LinkedIn: [PREENCHER: link do LinkedIn]
Portfólio: [PREENCHER: link do portfólio]

Status: 🚧 Em desenvolvimento

O Nexo tem como objetivo ser um projeto de backend completo, utilizado para praticar e demonstrar arquitetura de aplicações, modelagem relacional, APIs REST, regras de negócio, segurança, testes automatizados, Docker e integração contínua, mantendo uma evolução incremental e evitando complexidade artificial.
