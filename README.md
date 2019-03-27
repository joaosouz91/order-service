# order-service

-------------------------------------------------------
POST
http://localhost:8080/order-service/
{
    "pessoa": {
        "nomeCompleto": "Joao Victor de Souza",
        "email": "joaovictor.souz@gmail.com",
        "enderecoCompleto": "Rua Nebraska 246"
    },
    "itens": [
        {
            "produto": {
                "codigo": "A1",
                "descricao": "Produto A1",
                "valorUnitario": 90.2345
            },
            "quantidade": 2
        },
        {
            "produto": {
                "codigo": "B2",
                "descricao": "Produto B2",
                "valorUnitario": 72.6745
            },
            "quantidade": 7
        }
    ],
    "pagamento": {
        "formaPagamento": "CREDITO",
        "numeroCartao": "1234 2343 3422 3213",
        "validadeCartao": "2027-03",
        "bandeiraCartao": "MASTERCARD"
    },
    "dataCriacaoPedido": "2019-03-01 23:43:49.767",
    "status": "PENDING"
}

-------------------------------------------------------
PUT
http://localhost:8080/order-service/

{
	"idOrder": {idOrder},
    "pessoa": {
        "nomeCompleto": "Joao Victor de Souza",
        "email": "joaovictor.souz@gmail.com",
        "enderecoCompleto": "Rua Nebraska 246"
    },
    "itens": [
        {
            "produto": {
                "codigo": "A1",
                "descricao": "Produto A1",
                "valorUnitario": 56.12
            },
            "quantidade": 6
        }
    ],
    "pagamento": {
        "formaPagamento": "CREDITO",
        "numeroCartao": "1234 2343 3422 3213",
        "validadeCartao": "2027-03",
        "bandeiraCartao": "MASTERCARD"
    },
    "dataCriacaoPedido": "2019-03-01 23:43:49.767"
}

-------------------------------------------------------
GET
http://localhost:8080/order-service/{idOrder}
-------------------------------------------------------
DELETE
http://localhost:8080/order-service/{idOrder}
-------------------------------------------------------
