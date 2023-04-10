
CREATE TABLE IF NOT EXISTS documentos_profissionais(
		documentos_profissionais_id SERIAL primary key,
		pis varchar(255) UNIQUE NOT NULL,
		carteira_de_trabalho varchar(255) UNIQUE NOT NULL);	 
		
CREATE TABLE IF NOT EXISTS profissionais(
	id SERIAL primary key,
	cargo varchar(100) NOT NULL,
	remuneracao numeric(38, 2) NOT NULL,
	tipo_de_profissional varchar(255) NOT NULL,	
	
	documentos_profissionais_id int NOT NULL,
	
	
	CONSTRAINT cidadaos
	FOREIGN KEY(id) 
	REFERENCES cidadaos(id),
	
   CONSTRAINT fk_documentos_profissionais
      FOREIGN KEY(documentos_profissionais_id) 
	  REFERENCES documentos_profissionais(documentos_profissionais_id));