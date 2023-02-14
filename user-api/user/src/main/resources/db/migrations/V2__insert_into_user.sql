-- Insert into pg admin
INSERT INTO users."user"(id, nome, cpf, endereco, email, telefone, data_cadastro)
VALUES
	(1, 'Eduardo', '35567654534', 'Rua a', 'eduardo@email.com', '1234-3454', '2019-11-17T21:04:51.701+0000'),
    (2, 'Luiz', '45603304407', 'Rua b', 'luiz@email.com', '1234-3454', '2019-11-17T21:04:51.701+0000');
	(3, 'Bruna', '67823407707', 'Rua c', 'bruna@email.com', '1234-3454', '2019-11-17T21:04:51.701+0000'),
    (4, 'Carlos', '98757843404', 'Avenida 2', 'carlos@email.com', '1234-3454', '2019-11-17T21:04:51.701+0000');
SELECT * FROM users."user";
--