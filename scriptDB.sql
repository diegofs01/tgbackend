DROP TABLE ocorrencia;
DROP TABLE tipoOcorrencia;
DROP TABLE veiculo;
DROP TABLE aluno;
DROP TABLE curso;

CREATE TABLE curso (
	id SERIAL PRIMARY KEY,
	nome TEXT NOT NULL
);

CREATE TABLE aluno (
	ra VARCHAR(15) PRIMARY KEY,
	nome TEXT NOT NULL,
	cpf VARCHAR(15) UNIQUE,
	rg VARCHAR(15) NOT NULL,
	endereco TEXT NOT NULL,
	numero int NOT NULL,
	complemento TEXT,
	bairro TEXT NOT NULL,
	cidade TEXT NOT NULL,
	estado TEXT NOT NULL,
	cep VARCHAR(10) NOT NULL,
	numeroTelefone VARCHAR(15),
	numeroCelular VARCHAR(15),
	email VARCHAR(50),
	idCurso INTEGER references curso(id) ON DELETE CASCADE
);

CREATE TABLE veiculo (
	placa VARCHAR(10) PRIMARY KEY,
	marca TEXT not null,
	modelo TEXT not null,
	anoModelo INTEGER not null,
	anoFabricacao INTEGER not null,
	cor TEXT not null,
	paisFabricacao TEXT not null,
	raAluno VARCHAR(15) REFERENCES aluno(ra) ON DELETE CASCADE
);

CREATE TABLE tipoOcorrencia (
	id SERIAL PRIMARY KEY,
	nome TEXT NOT NULL
);

CREATE TABLE ocorrencia (
	numero SERIAL PRIMARY KEY,
	placaVeiculo VARCHAR(10),
	data DATE NOT NULL,
	hora TIME NOT NULL,
	descricao TEXT NOT NULL,
	tipoOcorrencia INTEGER REFERENCES tipoOcorrencia(id) ON DELETE CASCADE,
	veiculoCadastrado BOOLEAN NOT NULL
);

INSERT INTO curso (nome) 
	VALUES('Anaĺise e Desenvolvimento de Sistemas');
INSERT INTO curso (nome)
	VALUES('Logística');

INSERT INTO aluno (ra, nome, cpf, rg, endereco, numero, complemento, bairro, cidade, estado, cep, numeroTelefone, numeroCelular, email, idCurso)
	VALUES('0030481421044', 'Valter Massashi Akashi', '439.920.230-20', '13.312.430-0', 'Liberdade', '50', '', 'Seul', 'Piedade', 'São Paulo', '19023-203', '(15) 3224-3453', '(15) 99649-2390', 'massashi.akashi@hotmail.com', 1);
INSERT INTO aluno (ra, nome, cpf, rg, endereco, numero, complemento, bairro, cidade, estado, cep, numeroTelefone, numeroCelular, email, idCurso)
	VALUES('0030481421048', 'Diego Ferreira Silva', '450.059.448-50', '48.716.409-X', 'Bonifacio de Oliveira Cassu', 80, 'Pista de Skate', 'Éden', 'Sorocaba', 'São Paulo', '18103-100', '(15) 3325-2638', '(15) 99751-3436', 'diegofs01@hotmail.com', 1);

INSERT INTO veiculo (placa, marca, modelo, anoModelo, anoFabricacao, cor, paisFabricacao, raAluno)
	VALUES ('JPN-1999', 'Nissan', 'Skyline GTR R34', 1999, 1999, 'Cinza', 'Japão', '0030481421044');
INSERT INTO veiculo (placa, marca, modelo, anoModelo, anoFabricacao, cor, paisFabricacao, raAluno)
	VALUES ('GER-2004', 'BMW', 'M5 GTR', 2004, 2005, 'Preto', 'Alemanha', '0030481421048');
INSERT INTO veiculo (placa, marca, modelo, anoModelo, anoFabricacao, cor, paisFabricacao, raAluno)
	VALUES ('USA-2005', 'Chevrolet', 'Cobalt SS', 2005, 2006, 'Azul', 'Estados Unidos', '0030481421048');
INSERT INTO veiculo (placa, marca, modelo, anoModelo, anoFabricacao, cor, paisFabricacao, raAluno)
	VALUES ('BRA-2010', 'Fiat', 'Uno Economy', 2010, 2010, 'Branco', 'Brasil', '0030481421044');
	
INSERT INTO tipoOcorrencia (nome)
	VALUES ('Outros');
INSERT INTO tipoOcorrencia (nome)
	VALUES ('Farol Aceso');
INSERT INTO tipoOcorrencia (nome)
	VALUES ('Estacionado em Local Errado');

INSERT INTO ocorrencia (placaVeiculo, data, hora, descricao, tipoOcorrencia, veiculoCadastrado)
	VALUES ('JPN-1999', '2017-10-17', '12:00', 'Driftando dentro do campus', 1, true);
INSERT INTO ocorrencia (placaVeiculo, data, hora, descricao, tipoOcorrencia, veiculoCadastrado)
	VALUES ('GER-2004', '2017-10-14', '21:45', 'Estacionado ocupando 2 vagas', 3, true);
INSERT INTO ocorrencia (placaVeiculo, data, hora, descricao, tipoOcorrencia, veiculoCadastrado)
	VALUES ('USA-2005', '2017-10-11', '20:30', 'Som com alto volume', 1, true);
INSERT INTO ocorrencia (placaVeiculo, data, hora, descricao, tipoOcorrencia, veiculoCadastrado)
	VALUES ('BRA-2010', '2017-10-07', '10:55', 'Estacionado com farol aceso', 2, true);