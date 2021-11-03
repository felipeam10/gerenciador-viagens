Projeto utilizado no treinamento DTAR - Julio de Lima

Este é um repositório para aprender um pouco mais sobre APIs REST.

Nele existem vários problemas e más práticas para serem utilizadas como exemplo do que não fazer.

----------------------------------------------------------------------------------------------------------------

URL Swagger: http://localhost:8089/api/swagger-ui.html

Use: https://jwt.io/ 
para verificar tokens

https://www.base64decode.org/

Variáveis dinâmicas no Postman
https://learning.postman.com/docs/writing-scripts/script-references/variables-list/


Http Status:
https://httpstatusdogs.com/


----------------------------------------------------------------------------------------------------------------
Módulo 5 - Aula 10

Validar aderência ao contrato(swagger)

quando fizer um POST http://localhost:8089/api/v1/viagens
pegar o body da resposta, exemplo:

{
    "data": {
        "id": 1,
        "localDeDestino": "Ceara",
        "dataPartida": "2022-02-10",
        "dataRetorno": "2022-02-10",
        "acompanhante": "Valentine",
        "regiao": "Norte"
},
    "errors": []
}

e gerar um jsonSchema dele: 

https://www.jsonschema.net/home

no postman e na aba tests, criar uma const e inserir o jsonSchema criado
ver na colection do POST "cadastra viagem" aba tests
criar tbm um teste que valida o jsonSchema:

pm.test("Validar estrutura do POST Cadastra Viagem com 201", () => {
    pm.response.to.jsonSchema(modeloEsperadoParaPostViagens);
});

----------------------------------------------------------------------------------------------------------------

