package br.com.magnasistemas.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.api.exception.BadRequestExceptionHandler;
import br.com.magnasistemas.api.exception.NotFoundExceptionHandler;
import br.com.magnasistemas.api.model.Cidadao;
import br.com.magnasistemas.api.records.cidadao.DadosAtualizacaoCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosCadastroCidadao;
import br.com.magnasistemas.api.records.cidadao.DadosListagemCidadao;
import br.com.magnasistemas.api.repository.CidadaoRepository;

@Service
public class CidadaoService {

	@Autowired
	private CidadaoRepository repository;

	@Autowired
	private EnderecoService enderecos;
	@Autowired
	private ContatoService contatos;

	@Autowired
	private DocumentosService documento;

	public Cidadao criarCidadao(DadosCadastroCidadao dados) {

		Cidadao cidadao = new Cidadao();
		cidadao.setNome(dados.pessoa().nome());
		cidadao.setDataDeNascimento(dados.pessoa().dataDeNascimento());
		cidadao.setEtnia(dados.pessoa().etnia());
		cidadao.setGenero(dados.pessoa().genero()); 
		cidadao.setEndereco(enderecos.criarEndereco(dados.pessoa().endereco()));
		cidadao.setContato(contatos.criarContato(dados.pessoa().contato()));
		cidadao.setDocumentos(documento.criarDocumento(dados.documentos()));
		cidadao.setEscolaridade(dados.escolaridade());
		cidadao.setSituacaoEscolar(dados.situacaoEscolar());

		return repository.save(cidadao);
	}

	public List<DadosListagemCidadao> listarCidadao() {
		List<DadosListagemCidadao> get = repository.findAll().stream().map(DadosListagemCidadao::new).toList();
		if (get.isEmpty())
			throw new NotFoundExceptionHandler("Não foi possível localizar os dados, tente cadastrar algum cidadão");
		return get;
	}

	public DadosListagemCidadao listarPorID(Long id) {
		Optional<DadosListagemCidadao> get = repository.findById(id).map(DadosListagemCidadao::new);

		return get.orElseThrow(BadRequestExceptionHandler::new);

	}

	public Cidadao atualizarCidadao(DadosAtualizacaoCidadao dados) {
		Optional<Cidadao> cid = repository.findById(dados.id());
		if (cid.isEmpty())
			throw new BadRequestExceptionHandler();

		Cidadao cidadao = cid.get();
		cidadao.setNome(dados.pessoa().nome());
		cidadao.setEndereco(enderecos.atualizarEndereco(dados.pessoa(), cidadao));
		cidadao.setContato(contatos.atualizarContato(dados.pessoa(), cidadao));
		cidadao.setEscolaridade(dados.escolaridade());
		cidadao.setSituacaoEscolar(dados.situacaoEscolar());

		return repository.save(cid.get());
	}

	public void deletarCidadao(Long id) {

		Cidadao cidadao = repository.findById(id).orElseThrow(BadRequestExceptionHandler::new);

		repository.deleteById(cidadao.getId());
	}

}
