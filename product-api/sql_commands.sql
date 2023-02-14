select * from products.category;
select * from products.product;

-- INSERT DATA
INSERT INTO products.product (id, product_identifier, nome, preco, descricao, category_id)
VALUES
    (1, "NOTEBOOK", "Mac book Air", 5500, "M1 - 256GB", 1),
    (2, "SMARTPHONE", "Galaxy S10+ Plus", 2000, "Samsung - G975U1 - 128GB", 1),
    (3, "MESA", "Mesa para escritório", 2750, "formato em L", 2),
    (4, "SAPATEIRA", "Sapateira em Bambu", 300, "Preta 33x66x28cm ", 2),
    (5, "LEGO", "LEGO - Ford Mustang Shelby GT500", 212, "544 Peças", 3),
    (6, "BONECA", "Hospital Movel Dos Bichinhos", 5500, "Polly Pocket", 3);