package br.com.magnasistemas.api.service;

import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.model.Documento;
import br.com.magnasistemas.api.records.documentos.DadosDocumento;
@Service
public class DocumentosService {

	public Documento criarDocumento(DadosDocumento documentos) {
		Documento docs = new Documento();
		docs.setCertidaDeNascimento(documentos.certidaDeNascimento()); 
		docs.setCpf(documentos.cpf()); 
		docs.setRg(documentos.rg());
		return docs;
	}

}
