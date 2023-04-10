package br.com.magnasistemas.api.service;

import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.model.DocumentosProfissionais;
import br.com.magnasistemas.api.records.documentos_profissionais.DadosDocumentosProfissionais;
@Service
public class DocumentosProfissionaisService {

	public DocumentosProfissionais criarDocumentoProfissional(DadosDocumentosProfissionais documentosProfissionais) {
		DocumentosProfissionais docs = new DocumentosProfissionais();
		docs.setCarteiraDeTrabalho(documentosProfissionais.carteiraDeTrabalho());
		docs.setPis(documentosProfissionais.pis());
		return docs;
	}

}
