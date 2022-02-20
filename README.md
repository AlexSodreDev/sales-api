# Sales API

Aplicação com finalidade de cadastrar vendas e vendedores, através de relacionamento entre as tabelas.

## Instruções

Após ter feito o checkout do projeto, acesse sales.api, rode o comando:

```bash
mvn clean install
```

Com o build realizado corretamente, você terá acesso aos serviços através dos seguintes endpoints.

### Acesso a aplicação

```bash
http://localhost:8080
```

## Endpoints de Acesso a API

Através dos endpoints abaixo você será capaz de realizar as ações de acordo com o título.

### POST - Criação de Vendedores

Recebe os dados através de um objeto JSON:

{
"name": "Vendedor1",
"salesAmount": "10",
"dailySalesAverage": "2"
}

```bash
http://localhost:8080/seller
```

### GET - Listagem de Vendedores

Realiza a listagem de todos os vendedores cadastrados:

```bash
http://localhost:8080/seller
```

### GET - Busca de Vendedores

Realiza a busca de um vendedor especifico através do ID:

```bash
http://localhost:8080/seller/{id}
```

### DELETE - Exclusão de Colaboradores

Realiza a exclusão de um vendedor através do ID:

```bash
http://localhost:8080/seller/{id}
```
