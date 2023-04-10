CREATE TABLE IF NOT EXISTS documentos(
		documentos_id SERIAL primary key,
		certida_de_nascimento varchar(255) UNIQUE NOT NULL,
		cpf varchar(255) UNIQUE NOT NULL,
		rg varchar(255) UNIQUE NOT NULL);



CREATE TABLE IF NOT EXISTS cidadaos(
	id SERIAL primary key,
	escolaridade varchar(80) NOT NULL,
	situacao_escolar varchar(80) NOT NULL,
	
	documentos_id int NOT NULL,
	
	
	CONSTRAINT fk_pessoas
	FOREIGN KEY(id) 
	REFERENCES pessoas(id),
	
   CONSTRAINT fk_documentos
      FOREIGN KEY(documentos_id) 
	  REFERENCES documentos(documentos_id));