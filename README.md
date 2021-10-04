# Desafio CompassoUol Java com SringBoot

Sua tarefa é implementar um catálogo de produtos com Java e Spring Boot.

Neste microserviço deve ser possível criar, alterar, visualizar e excluir um determinado produto, além de visualizar a lista de produtos atuais disponíveis. 

Também deve ser possível realizar a busca de produtos filtrando por name, description e price.


## Tarefas executadas:

* Criação de um produto - OK

* Atualização de um produto - OK

* Busca de um produto por ID - OK

* Lista de produtos - OK

* Lista de produtos filtrados - OK

* Deleção de um produto - OK
  
* Expor na porta 9999 - OK

* Testes unitários - OK

* Erro 400 customizado (BadRequest) - OK
  
* Validações de campos durante criação e atualização de Produtos - OK

* Método de entrega: Através de build utilizando Docker (DockerFile disponível na raiz do Projeto). - OK

*  Documentação - OK





## Instruções para executar a aplicação

### Pré Requisitos:
Docker (testado com versao v20.10.7 para Windows com WSL2)

Internet

**1) Na raiz do projeto, executar:**
```
docker build -t desafio .
```
**2)Após finalização, executar o comando abaixo e mapear a porta 9999**

#### Modo interativo #### 
```
docker run -p 9999:9999 desafio 
```
#### Modo serviço #### 
```
docker run -d -p 9999:9999 desafio 
```

**3) Para finalizar a execução**
#### Modo interativo #### 
```
Ctrl+C 
```

#### Modo serviço ####

**docker ps (buscar pelo Container ID do container com nome desafio)**
```
docker stop ContainerID
```
**Para remover**
```
docker rm ContainerID
docker image rm desafio
```