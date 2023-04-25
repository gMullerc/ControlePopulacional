package br.com.magnasistemas.service;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.entity.Cidadao;
import br.com.magnasistemas.exception.BadRequestExceptionHandler;
import br.com.magnasistemas.repository.CidadaoRepository;
import br.com.magnasistemas.repository.historico.HistoricoCidadaoRepository;
import br.com.magnasistemas.utils.GerarHistoricoCidadao;

@Service
public class CidadaoService {

	@Autowired
	private CidadaoRepository repository;

	@Autowired
	private HistoricoCidadaoRepository historicoRepository;

	@Autowired
	private GerarHistoricoCidadao cidadaoHistorico;

	public Cidadao criarCidadao(Cidadao dados) {
		Cidadao cidadao = new Cidadao();
		cidadao.setNome(dados.getNome());
		cidadao.setDataDeNascimento(dados.getDataDeNascimento());
		cidadao.setEtnia(dados.getEtnia());
		cidadao.setGenero(dados.getGenero());
		cidadao.setEndereco(dados.getEndereco());
		cidadao.setContato(dados.getContato());
		cidadao.setDocumentos(dados.getDocumentos());
		cidadao.setEscolaridade(dados.getEscolaridade());
		cidadao.setSituacaoEscolar(dados.getSituacaoEscolar());
		cidadao.setTimeStamp(ZonedDateTime.now());
		cidadao.setUsuario(dados.getUsuario());
		Cidadao retorno = repository.save(cidadao);
		historicoRepository.save(cidadaoHistorico.registrarNovoCidadao(retorno));
		return cidadao;

	}

	public Page<Cidadao> listagem(Pageable paginacao) {
		return repository.findAll(paginacao).map(c -> c);
	}

	public Cidadao listarPorID(Long id) {
		Optional<Cidadao> get = repository.findById(id).map(cidadao -> cidadao);
		return get.orElseThrow(BadRequestExceptionHandler::new);
	}

	public Cidadao atualizarCidadao(Cidadao dados) {

		Optional<Cidadao> validarCidadao = repository.findById(dados.getId());

		if (validarCidadao.isEmpty())
			throw new BadRequestExceptionHandler();

		Cidadao dadosAnteriores = validarCidadao.get();
		Cidadao atualizarCidadao = dadosAnteriores;
		atualizarCidadao.setNome(dados.getNome());
		atualizarCidadao.setEndereco(dados.getEndereco());
		atualizarCidadao.setContato(dados.getContato());
		atualizarCidadao.setEscolaridade(dados.getEscolaridade());
		atualizarCidadao.setSituacaoEscolar(dados.getSituacaoEscolar());
		Cidadao retorno = repository.save(validarCidadao.get());
		historicoRepository.save(cidadaoHistorico.registroDeAtualizacaoDeCidadao(retorno));
		return retorno;
	}

	public void deletarCidadao(Long id) {

		Cidadao cidadao = repository.findById(id).orElseThrow(BadRequestExceptionHandler::new);

		repository.deleteById(cidadao.getId());
	}

}
