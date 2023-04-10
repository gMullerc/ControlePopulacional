package br.com.magnasistemas.api.records.profissional;

import java.math.BigDecimal;
import java.util.List;

import br.com.magnasistemas.api.enumerator.enumEscolaridade;
import br.com.magnasistemas.api.enumerator.enumGenero;
import br.com.magnasistemas.api.enumerator.enumSituacaoEscolar;
import br.com.magnasistemas.api.enumerator.enumTipoDeProfissional;
import br.com.magnasistemas.api.model.Contato;
import br.com.magnasistemas.api.model.Documento;
import br.com.magnasistemas.api.model.DocumentosProfissionais;
import br.com.magnasistemas.api.model.Endereco;
import br.com.magnasistemas.api.model.Profissional;

public record DadosListagemProfissional(Long id, String nome, enumGenero genero, List<Endereco> endereco,
		List<Contato> contato, enumSituacaoEscolar situacaoEscolar, enumEscolaridade Escolaridade, Documento documentos,
		String cargo, enumTipoDeProfissional TipoDeprofissional, BigDecimal remuneracao,
		DocumentosProfissionais documentosProfissionais) {

	public DadosListagemProfissional(Profissional cid) {
		this(cid.getId(), cid.getNome(), cid.getGenero(), cid.getEndereco(), cid.getContato(), cid.getSituacaoEscolar(),
				cid.getEscolaridade(), cid.getDocumentos(), cid.getCargo(), cid.getTipoDeProfissional(),
				cid.getRemuneracao(), cid.getDocumentosProfissionais());
	}

}
