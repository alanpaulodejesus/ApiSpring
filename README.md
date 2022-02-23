# ApiSpring

 - Banco H2 usado com http://localhost:8080/h2-console
 - Acesso local: http://localhost:8080/api/clientes


Requisição local:

curl --location --request POST 'http://localhost:8080/api/clientes' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome":"Joãozinho"
}'

curl --location --request GET 'http://localhost:8080/api/clientes/1'

curl --location --request DELETE 'http://localhost:8080/api/clientes/2'

curl --location --request PUT 'http://localhost:8080/api/clientes/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome":"Tadeu"
}'
