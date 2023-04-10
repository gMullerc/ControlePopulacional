package br.com.magnasistemas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.magnasistemas.api.model.Profissional;
import br.com.magnasistemas.api.records.profissional.DadosAtualizacaoProfissional;
import br.com.magnasistemas.api.records.profissional.DadosCadastroProfissional;
import br.com.magnasistemas.api.records.profissional.DadosListagemProfissional;
import br.com.magnasistemas.api.service.ProfissionalService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("profissional")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Profissional> criarProfissional(@RequestBody DadosCadastroProfissional profissional) {
		service.criaProfissional(profissional);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<DadosListagemProfissional>> procurar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarProfissional());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DadosListagemProfissional> procurarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.listarPorID(id));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Profissional> atualizar(@RequestBody @Valid DadosAtualizacaoProfissional dados) {
		service.atualizarProfissional(dados);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		service.deletarProfissional(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
