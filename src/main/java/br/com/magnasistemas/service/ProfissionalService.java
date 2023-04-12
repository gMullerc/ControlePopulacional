package br.com.magnasistemas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magnasistemas.entity.Profissional;
import br.com.magnasistemas.exception.BadRequestExceptionHandler;
import br.com.magnasistemas.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;

	public Profissional criaProfissional(Profissional dados) {

		Profissional profissional = new Profissional();
		profissional.setNome(dados.getNome());
		profissional.setDataDeNascimento(dados.getDataDeNascimento());
		profissional.setEtnia(dados.getEtnia());
		profissional.setGenero(dados.getGenero());
		profissional.setEndereco(dados.getEndereco());
		profissional.setContato(dados.getContato());
		profissional.setEscolaridade(dados.getEscolaridade());
		profissional.setSituacaoEscolar(dados.getSituacaoEscolar());
		profissional.setCargo(dados.getCargo());
		profissional.setRemuneracao(dados.getRemuneracao());
		profissional.setTipoDeProfissional(dados.getTipoDeProfissional());
		profissional.setDocumentosProfissionais(dados.getDocumentosProfissionais());

		return repository.save(profissional);
	}

	public Page<Profissional> listagem(Pageable paginacao) {
		return repository.findAll(paginacao).map(c -> c);
	}

	public Profissional listarPorID(Long id) {
		Optional<Profissional> get = repository.findById(id).map(profissional -> profissional);

		return get.orElseThrow(BadRequestExceptionHandler::new);
	}

	public Profissional atualizarProfissional(Profissional dados) {
		Optional<Profissional> prof = repository.findById(dados.getId());
		if (prof.isEmpty())
			throw new BadRequestExceptionHandler();

		Profissional profissional = repository.getReferenceById(dados.getId());
		profissional.setNome(dados.getNome());
		profissional.setEndereco(dados.getEndereco());
		profissional.setContato(dados.getContato());
		profissional.setEscolaridade(dados.getEscolaridade());
		profissional.setSituacaoEscolar(dados.getSituacaoEscolar());
		profissional.setCargo(dados.getCargo());
		profissional.setRemuneracao(dados.getRemuneracao());
		profissional.setTipoDeProfissional(dados.getTipoDeProfissional());

		return repository.save(prof.get());

	}

	public void deletarProfissional(Long id) {
		Profissional prof = repository.findById(id).orElseThrow(BadRequestExceptionHandler::new);

		repository.deleteById(prof.getId());

	}

}
