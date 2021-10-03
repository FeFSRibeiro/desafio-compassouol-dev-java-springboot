# Instruções para executar a aplicação

## Pré Requisitos:
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