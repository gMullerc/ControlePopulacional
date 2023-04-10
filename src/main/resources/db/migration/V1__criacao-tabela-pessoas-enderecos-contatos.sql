CREATE TABLE IF NOT EXISTS pessoas(
	id SERIAL primary key,
	data_de_nascimento date NOT NULL,
	etnia int NULL,	
	genero varchar(255) NULL,
	nome varchar(255) NULL,
	contatos_id int NULL,
	enderecos_id int NULL
	);

	  
	  
CREATE TABLE IF NOT EXISTS contatos(

	contatos_id SERIAL primary key,
	celular varchar(255) UNIQUE NULL,
	email varchar(255) UNIQUE NULL,
	telefone varchar(255) UNIQUE NULL,
	pessoa_id int NULL,
	
	CONSTRAINT fk_pessoas
      FOREIGN KEY(pessoa_id) 
	  REFERENCES pessoas(id));
	  
CREATE TABLE IF NOT EXISTS enderecos(

	enderecos_id SERIAL primary key,
	bairro varchar(255) NOT NULL,
	cep varchar(255) NOT NULL,
	cidade varchar(255) NOT NULL,
	complemento varchar(255) NULL,
	logradouro varchar(255) NOT NULL,
	numero varchar(255) NOT NULL,
	uf varchar(255) NOT NULL,
	pessoa_id int NULL,
	
	CONSTRAINT fk_pessoas
      FOREIGN KEY(pessoa_id) 
	  REFERENCES pessoas(id));
	


ALTER TABLE pessoas
    ADD CONSTRAINT fk_enderecos FOREIGN KEY (enderecos_id) REFERENCES enderecos (enderecos_id);

ALTER TABLE pessoas
    ADD CONSTRAINT fk_contatos FOREIGN KEY (contatos_id) REFERENCES contatos (contatos_id);
	  