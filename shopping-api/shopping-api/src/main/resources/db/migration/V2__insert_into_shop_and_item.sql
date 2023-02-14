INSERT INTO shopping.shop (id, user_identifier, date, total)
VALUES (1, 'Baciliere', '2019-11-17T21:04:51.701+0000', 0),
       (2, 'Luciano', '2019-11-17T21:04:51.701+0000', 0),
       (3, 'Karla', '2019-11-17T21:04:51.701+0000', 0),
       (4, 'Italo', '2019-11-17T21:04:51.701+0000', 0),
       (5, 'Letícia', '2019-11-17T21:04:51.701+0000', 0);

INSERT INTO shopping.item (shop_id, product_identifier, price)
VALUES (1, 'TV', 2000),
       (1, 'NOTEBOOK', 7000),
       (1, 'SMARTPHONE', 3000),
       (2, 'TECLADO', 1000),
       (3, 'MESA', 2000),
       (3, 'SAPATEIRA', 300),
       (4, 'TECLADO', 500),
       (4, 'HEADPHONE', 2000),
       (4, 'BONECA', 500),
       (5, 'LEGO', 500);