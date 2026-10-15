-- Usuário
INSERT INTO usuario (id, nome_completo, email, cpf, senha)
VALUES
    (1, 'João Silva', 'joao.silva@email.com', '12345678901', '$2a$10$VDIdQHkady8ufOOf9W5IMen7Q/Fa0BCQ.2WweaiH2FmYxLZgjoaCm'),
    (2, 'Maria Oliveira', 'maria.oliveira@email.com', '98765432100', '$2a$10$VDIdQHkady8ufOOf9W5IMen7Q/Fa0BCQ.2WweaiH2FmYxLZgjoaCm'),
    (3, 'Carlos Souza', 'carlos.souza@email.com', '11122233344', '$2a$10$VDIdQHkady8ufOOf9W5IMen7Q/Fa0BCQ.2WweaiH2FmYxLZgjoaCm');

-- FormaPagamento
INSERT INTO forma_pagamento (id, nome_cartao, titular_cartao, numero_cartao, status, usuario_id)
VALUES  (1, 'Visa', 'João Silva', '4111111111111111', TRUE, 1),
        (2, 'Mastercard', 'Maria Oliveira', '5500000000000004', TRUE, 2),
        (3, 'Elo', 'Carlos Souza', '6362970000457013', FALSE, 3);

-- Endereço
INSERT INTO endereco (id, cep, estado, cidade, bairro, rua, numero, complemento, status, usuario_id)
VALUES  (1, '96020360', 'RS', 'Pelotas', 'Centro', 'Rua Andrade Neves', '100', 'Apto 201', TRUE, 1),
        (2, '01001000', 'SP', 'São Paulo', 'Sé', 'Praça da Sé', '200', NULL, TRUE, 2),
        (3, '20040002', 'RJ', 'Rio de Janeiro', 'Centro', 'Rua da Quitanda', '300', 'Sala 5', FALSE, 3);

-- Produto
INSERT INTO produto (id, nome_produto, estoque, preco_unitario, status)
VALUES  (1, 'Notebook Dell Inspiron', 10, 3500.00, TRUE),
        (2, 'Smartphone Samsung Galaxy', 20, 2500.00, TRUE),
        (3, 'Cafeteira Elétrica', 15, 300.00, TRUE),
        (4, 'Fone de Ouvido Bluetooth', 50, 150.00, TRUE),
        (5, 'Monitor LG 24"', 8, 900.00, FALSE);

-- Pedido
INSERT INTO pedido (id, valor_total, status, endereco_id, pagamento_id, usuario_id)
VALUES  (1, 3650.00, TRUE, 1, 1, 1),
        (2, 2500.00, TRUE, 2, 2, 2),
        (3, 450.00, FALSE, 3, 3, 3);

-- PedidoItem
INSERT INTO pedido_item (id, quantidade, preco_unitario, pedido_id, produto_id)
VALUES  (1, 1, 3500.00, 1, 1),
        (2, 1, 2500.00, 2, 2),
        (3, 3, 150.00, 3, 3);

INSERT INTO perfis (id, nome)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO usuarios_perfis (usuarios_id, perfis_id)
VALUES  (1, 1),
        (2, 2),
        (3, 2);
