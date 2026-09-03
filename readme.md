# Documentação da api
O projeto consiste na criação de um marketplace, onde o usuário pode cadastrar os seus endereços, cartões e realizar pedidos.

## Usuario
Classe responsável pelas informações básicas do usuario\
`Long id - identificação única do usuário`\
`String nomeCompleto - nome do usuário`\
`String email - email do usuário`\
`String cpf - cpf do usuário, campo único`\
`String senha - senha do usuário`

## FormaPagamento
Classe responsável pelas informações dos cartões do usuario\
`Long id - identificação única da forma de pagamento`\
`String nomeCartao - identificador do cartão do usuario`\
`String titularCartao - nome do titular do cartão`\
`String numeroCartao - numero do cartão do usuário`\
`Boolean status - cartão ativo/inativo`

## Endereço
Classe responsável pelas informações dos endereços do usuario\
`Long id - identificação única do endereço`\
`String cep - cep do endereço`\
`String estado - estado do endereço`\
`String cidade - cidade do endereço`\
`String bairro - bairro do endereço`\
`String rua - rua do endereço`\
`String numero - numero do endereço`\
`String complemento - complemento do endereço`\
`Boolean status - endereço ativo/inativo`

## Produto
Classe responsável pelas informações dos produtos\
`Long id - identificação única do produto`\
`String nomeProduto - nome do produto`\
`BigDecimal estoque - estoque do produto`\
`BigDecimal precoUnitario - preço unitário do produto`\
`Boolean status - se o item está ativo ou não`

## PedidoItem
Classe responsável pelas informações dos itens do pedido\
`Long id - identificação única do item do pedido`\
`BigDecimal quantidade - quantidade do item comprada no pedido`\
`BigDecimal precoUnitario - preço unitário do produto no momento da venda`

## Pedido
Classe responsável pelas informações do produto\
`Long id - identificação única do pedido`\
`BigDecimal valorTotal - valor total do pedido`\
`Boolean status - situação do pedido`

