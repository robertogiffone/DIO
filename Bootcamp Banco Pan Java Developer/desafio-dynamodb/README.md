# dio-live-dynamodb
Desafio de projeto com referência da live coding do dia 30/09/2021 sobre o Amazon DynamoDB da DIO

### Serviço utilizado
  - Amazon DynamoDB
  - Amazon CLI para execução em linha de comando

### Comandos para execução do experimento:


- Criar uma tabela

```
aws dynamodb create-table \
    --table-name Filme \
    --attribute-definitions \
        AttributeName=Diretor,AttributeType=S \
        AttributeName=FilmeTitulo,AttributeType=S \
    --key-schema \
        AttributeName=Diretor,KeyType=HASH \
        AttributeName=FilmeTitulo,KeyType=RANGE \
    --provisioned-throughput \
        ReadCapacityUnits=10,WriteCapacityUnits=5
```

- Inserir um item

```
aws dynamodb put-item \
    --table-name Filme \
    --item file://itemfilme.json \
```

- Inserir múltiplos itens

```
aws dynamodb batch-write-item \
    --request-items file://batchfilme.json
```

- Criar um index global secundário baeado no gênero do filme

```
aws dynamodb update-table \
    --table-name Filme \
    --attribute-definitions AttributeName=TituloGenero,AttributeType=S \
    --global-secondary-index-updates \
        "[{\"Create\":{\"IndexName\": \"TituloGenero-index\",\"KeySchema\":[{\"AttributeName\":\"TituloGenero\",\"KeyType\":\"HASH\"}], \
        \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"
```

- Criar um index global secundário baseado no nome do artista e no título do álbum

```
aws dynamodb update-table \
    --table-name Filme \
    --attribute-definitions\
        AttributeName=Diretor,AttributeType=S \
        AttributeName=TituloGenero,AttributeType=S \
    --global-secondary-index-updates \
        "[{\"Create\":{\"IndexName\": \"DiretorTituloGenero-index\",\"KeySchema\":[{\"AttributeName\":\"Diretor\",\"KeyType\":\"HASH\"}, {\"AttributeName\":\"TituloGenero\",\"KeyType\":\"RANGE\"}], \
        \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"
```

- Criar um index global secundário baseado no título do filme e no ano

```
aws dynamodb update-table \
    --table-name Filme \
    --attribute-definitions\
        AttributeName=FilmeTitulo,AttributeType=S \
        AttributeName=AnoFilme,AttributeType=S \
    --global-secondary-index-updates \
        "[{\"Create\":{\"IndexName\": \"FilmeTituloYear-index\",\"KeySchema\":[{\"AttributeName\":\"FilmeTitulo\",\"KeyType\":\"HASH\"}, {\"AttributeName\":\"AnoFilme\",\"KeyType\":\"RANGE\"}], \
        \"ProvisionedThroughput\": {\"ReadCapacityUnits\": 10, \"WriteCapacityUnits\": 5      },\"Projection\":{\"ProjectionType\":\"ALL\"}}}]"
```

- Pesquisar item por diretor

```
aws dynamodb query \
    --table-name Filme \
    --key-condition-expression "Diretor = :diretor" \
    --expression-attribute-values  '{":diretor":{"S":"Patricia Riggen"}}'
```
- Pesquisar item por diretor e título do filme

```
aws dynamodb query \
    --table-name Filme \
    --key-condition-expression "Diretor = :diretor and FilmeTitulo = :titulo" \
    --expression-attribute-values file://keyconditions.json
```

- Pesquisa pelo index secundário baseado no título do gênero

```
aws dynamodb query \
    --table-name Filme \
    --index-name TituloGenero-index \
    --key-condition-expression "TituloGenero = :name" \
    --expression-attribute-values  '{":name":{"S":"Drama"}}'
```

- Pesquisa pelo index secundário baseado no nome do diretor e no título do gênero

```
aws dynamodb query \
    --table-name Filme \
    --index-name DiretorTituloGenero-index \
    --key-condition-expression "Diretor = :v_diretor and TituloGenero = :v_genero" \
    --expression-attribute-values  '{":v_diretor":{"S":"Patricia Riggen"},":v_genero":{"S":"Drama"} }'
```

- Pesquisa pelo index secundário baseado no título do filme e no ano

```
aws dynamodb query \
    --table-name Filme \
    --index-name FilmeTituloAno-index \
    --key-condition-expression "FilmeTitulo = :v_filme and AnoFilme = :v_ano" \
    --expression-attribute-values  '{":v_filme":{"S":"Milagres do Paraíso"},":v_ano":{"S":"2016"} }'
```
