
#  Safe Way

Esse é um teste técnico para avaliar meus conhecimentos.

## Appendix

O projeto tem como objetivo a criação de uma API simples que realize o cadastro de Usuarios, vendas e produtos. Sendo possível realizar a consulta desses dados desde que estajem inseridos no banco, podendo também atualizar e deletar seus dados. Abaixo, haverá informações que o auxiliarão no utilizamento da API.
## Authors

- [@lucasraimundo](https://www.github.com/LucasRaimundo)


## How to use?

1. Primeiro clone o repositório em sua maquina.

2. Em seguida, rode o projeto Spring Boot App.

3. O projeto inicia com uma instancia de banco então contendo 50 produtos, mas é preciso chamar os endpoints em uma sequencia especifica. Primeiro inserindo um cliente: 

- localhost:8080/users

OBS: Utilize o método POST

- {
    "name": "Lucas Raimundo",
    "email": "lucas@gmail.com",
    "cpf": 55555555588,
    "password": "123senha"
}





4. Para atualizar as informações do cliente, é necessário saber o seu perspectivo Id,  bastando utilizar o método PUT.
 
 - localhost:8080/users/1 

 



 5. Para realizar a deleção, também é necessário saber o respectivo Id, utilize a requisição abaixo: 
  
  - localhost:8080/users/1

  OBS: Utilize o método DELETE.

  6. Para visualizar os planetas que estão na base, utilize a requisição abaixo: 
  
  - localhost:8080/users

  OBS: Utilize o método GET.

  7. Logo em seguinda, você poderá fazer um pedido usando o metodo POST e a chamada a seguir:

  -localhost:8080/orders

  {
    "usuario" : {"id" : 1},
    "items" : [
                {
                    "quantity" : 2,
                    "product" : {"id" : 3}
                },
                {
                    "quantity" : 1,
                    "product" : {"id" : 1}
                }
             ]
}

8. Depois, para visualizar os pedidos basta utilizar o endpoint abaixo, ele trará as informações sobre o instante do pedido, quem foi o usuario (e todas suas informações), os itens do pedido (e todas suas informações) e o total da compra:

- localhost:8080/orders/1

OBS: Utilize o método GET
## Used stack

**Back-end:** Java, Spring Boot, Spring Web, H2, Maven e Git.



