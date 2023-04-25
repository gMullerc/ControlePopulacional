package br.com.magnasistemas.utils;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.entity.Profissional;
import br.com.magnasistemas.entity.historico.HistoricoProfissional;

@Service
public class GerarHistoricoProfissional {

	@Autowired
	private ConverterParaHistorico conversor;

	

	public HistoricoProfissional registrarNovoProfissional(Profissional dados) {

		HistoricoProfissional historicoRegistrarProfissional = new HistoricoProfissional();
 
		historicoRegistrarProfissional.setId(dados.getId());
		historicoRegistrarProfissional.setNome(dados.getNome());
		historicoRegistrarProfissional.setDataDeNascimento(dados.getDataDeNascimento());
		historicoRegistrarProfissional.setEtnia(dados.getEtnia());
		historicoRegistrarProfissional.setGenero(dados.getGenero());
		historicoRegistrarProfissional.setHistoricoEndereco(conversor.converterEnderecoParaHistoricoDeEnderecos(dados));
		historicoRegistrarProfissional.setHistoricoContato(conversor.converterContatoParaHistoricoDeContatos(dados));
		historicoRegistrarProfissional
				.setDocumentos(conversor.converterDocumentoParaHistoricoDeDocumentos(dados.getDocumentos()));
		historicoRegistrarProfissional.setEscolaridade(dados.getEscolaridade());
		historicoRegistrarProfissional.setSituacaoEscolar(dados.getSituacaoEscolar());
		historicoRegistrarProfissional.setTimeStamp(ZonedDateTime.now());

		historicoRegistrarProfissional.setCargo(dados.getCargo());
		historicoRegistrarProfissional.setDocumentosProfissionais(
				conversor.converterDocumentoProfissionalParaHistoricoDeDocumentosProfissionais(
						dados.getDocumentosProfissionais()));
		historicoRegistrarProfissional.setRemuneracao(dados.getRemuneracao());
		historicoRegistrarProfissional.setLastModify(ZonedDateTime.now());
		historicoRegistrarProfissional.setLastModify(ZonedDateTime.now());
		
		return historicoRegistrarProfissional;
	}

	

}
