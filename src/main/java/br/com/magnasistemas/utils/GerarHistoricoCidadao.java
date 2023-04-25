package br.com.magnasistemas.utils;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.entity.historico.HistoricoCidadao;
import br.com.magnasistemas.repository.CidadaoRepository;
import br.com.magnasistemas.repository.historico.HistoricoCidadaoRepository;

@Component
public class GerarHistoricoCidadao {

	@Autowired
	private ConverterParaHistorico conversor;

	@Autowired
	private HistoricoCidadaoRepository historicoCidadaoRepository;

	@Autowired
	private CidadaoRepository repository;

	public HistoricoCidadao registrarNovoCidadao(Cidadao dados) {

		HistoricoCidadao historicoRegistrarCidadao = new HistoricoCidadao();

		historicoRegistrarCidadao.setId(dados.getId());
		historicoRegistrarCidadao.setNome(dados.getNome());
		historicoRegistrarCidadao.setDataDeNascimento(dados.getDataDeNascimento());
		historicoRegistrarCidadao.setEtnia(dados.getEtnia());
		historicoRegistrarCidadao.setGenero(dados.getGenero());
		historicoRegistrarCidadao.setHistoricoEndereco(conversor.converterEnderecoParaHistoricoDeEnderecos(dados));
		historicoRegistrarCidadao.setHistoricoContato(conversor.converterContatoParaHistoricoDeContatos(dados));
		historicoRegistrarCidadao
				.setDocumentos(conversor.converterDocumentoParaHistoricoDeDocumentos(dados.getDocumentos()));
		historicoRegistrarCidadao.setEscolaridade(dados.getEscolaridade());
		historicoRegistrarCidadao.setSituacaoEscolar(dados.getSituacaoEscolar());
		historicoRegistrarCidadao.setTimeStamp(ZonedDateTime.now());
		historicoRegistrarCidadao.setLastModify(ZonedDateTime.now());
		return historicoCidadaoRepository.save(historicoRegistrarCidadao);
	}

	public HistoricoCidadao registroDeAtualizacaoDeCidadao(Cidadao dados) {

		HistoricoCidadao historicoRegistrarCidadao = new HistoricoCidadao();

		Optional<Cidadao> optionalCidadao = repository.findById(dados.getId());

		Cidadao cidadaoAnterior = optionalCidadao.get();
		historicoRegistrarCidadao.setId(cidadaoAnterior.getId());
		historicoRegistrarCidadao.getId();
		historicoRegistrarCidadao.setNome(cidadaoAnterior.getNome());
		historicoRegistrarCidadao.setDataDeNascimento(cidadaoAnterior.getDataDeNascimento());
		historicoRegistrarCidadao.setEtnia(cidadaoAnterior.getEtnia());
		historicoRegistrarCidadao.setGenero(cidadaoAnterior.getGenero());
		historicoRegistrarCidadao
				.setHistoricoEndereco(conversor.converterEnderecoParaHistoricoDeEnderecos(cidadaoAnterior));
		historicoRegistrarCidadao
				.setHistoricoContato(conversor.converterContatoParaHistoricoDeContatos(cidadaoAnterior));
		historicoRegistrarCidadao
				.setDocumentos(conversor.converterDocumentoParaHistoricoDeDocumentos(cidadaoAnterior.getDocumentos()));
		historicoRegistrarCidadao.setEscolaridade(cidadaoAnterior.getEscolaridade());
		historicoRegistrarCidadao.setSituacaoEscolar(cidadaoAnterior.getSituacaoEscolar());
		historicoRegistrarCidadao.setTimeStamp(cidadaoAnterior.getTimeStamp());
		historicoRegistrarCidadao.setLastModify(ZonedDateTime.now());
		historicoRegistrarCidadao.setUsuario(cidadaoAnterior.getUsuario());
		return historicoCidadaoRepository.save(historicoRegistrarCidadao);

	}

}
