
# Documentação do Teste Prático
Visão Geral

Este projeto foi desenvolvido em Java 21 (OpenJDK) e 
utiliza o Maven como gerenciador de dependências. 
O objetivo é manipular uma lista de funcionários, 
aplicando operações como filtragem, agrupamento, 
formatação e cálculos, utilizando a API de Stream e lambdas.

___

### Tecnologias Utilizadas
- Java 21 (OpenJDK): Versão LTS
- Maven: Gerenciador de dependências e build automation.


## Estrutura do Projeto

### Classes Principais

1. **`Pessoa`**:
    - Representa uma pessoa com os atributos:
        - `nome` (String)
        - `dataNascimento` (LocalDate)

2. **`Funcionario`**:
    - Estende a classe `Pessoa` e adiciona os atributos:
        - `salario` (BigDecimal)
        - `funcao` (String)

3. **`Main`**:
    - Classe principal que executa as operações solicitadas no teste.

---

## Funcionalidades Implementadas

#### 1. Inserção de Funcionários
- Todos os funcionários são inseridos em uma lista, conforme a tabela fornecida.

#### 2. Remoção do Funcionário "João"
- O funcionário "João" é removido da lista utilizando o método `removeIf`.

#### 3. Impressão Formatada dos Funcionários
- Os funcionários são impressos com:
    - Data de nascimento no formato `dd/MM/yyyy`.
    - Salário formatado com separador de milhar e decimal.

#### 4. Aumento de 10% no Salário
- O salário de todos os funcionários é aumentado em 10%.

#### 5. Agrupamento por Função
- Os funcionários são agrupados por função em um `Map<String, List<Funcionario>>`.

#### 6. Impressão dos Funcionários Agrupados por Função
- Para cada função, os funcionários são listados.

#### 7. Funcionários que Fazem Aniversário nos Meses 10 e 12
- Filtra e imprime os funcionários que fazem aniversário em outubro ou dezembro.

#### 8. Funcionário Mais Velho
- Identifica e imprime o funcionário mais velho, com base na data de nascimento.

#### 9. Funcionários em Ordem Alfabética
- Ordena e imprime os funcionários por nome.

#### 10. Total dos Salários
- Calcula e imprime a soma de todos os salários.

#### 11. Salários em Termos de Salários Mínimos
- Calcula e imprime quantos salários mínimos (R$ 1212,00) cada funcionário ganha.

---

## Como Executar o Projeto

### Pré-requisitos
- Java 21 (OpenJDK) instalado.
- Maven instalado.

### Passos

1. Clone o repositório ou copie o código para um diretório local.
2. Navegue até o diretório do projeto.
3. Compile o projeto com Maven:
   ```bash
   mvn clean compile

#### Execute

```bash
   mvn exec:java "-Dexec.mainClass=com.balsani.Principal"